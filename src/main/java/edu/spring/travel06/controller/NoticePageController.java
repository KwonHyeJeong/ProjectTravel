package edu.spring.travel06.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.FoodLikeVO;
import edu.spring.travel06.domain.FoodPageVO;
import edu.spring.travel06.domain.FoodWishVO;
import edu.spring.travel06.domain.FreePageVO;
import edu.spring.travel06.domain.NoticeVO;
import edu.spring.travel06.pageutil.PageCriteria;
import edu.spring.travel06.pageutil.PageMaker;
import edu.spring.travel06.security.CustomUserDetailsService;
import edu.spring.travel06.security.domain.CustomUser;
import edu.spring.travel06.service.FoodPageService;
import edu.spring.travel06.service.FreePageService;
import edu.spring.travel06.service.NoticePageService;

@Controller
@RequestMapping(value="/notice")
public class NoticePageController 
{
	private static final Logger logger = 
			LoggerFactory.getLogger(NoticePageController.class);
	
	@Autowired
	NoticePageService noticeService;
	
	@Autowired
	FreePageService freeService;
	
	@Autowired
	FoodPageService foodService;
	
	
	@Autowired
	CustomUserDetailsService cuds;
	
	
	@GetMapping("/listNotice")
	public void list(Model model, Principal princ,
			HttpSession session, String type, String keyword,
			Integer page, Integer perPage) throws Exception 
	{
		logger.info("공지사항 list 호출");
		
		logger.info("page = " + page + ", perPage = " + perPage);
		
		// Paging 처리
		PageCriteria criteria = new PageCriteria();
		if (page != null) 
		{
			criteria.setPage(page);
		}
		
		if (perPage != null) 
		{ 
			criteria.setNumsPerPage(perPage);
		}
		
		if(keyword != null) 
		{
			if(type.equals("all")) 
			{
				criteria.setType(type);
				criteria.setKeyword(keyword);
			}
			else if(type.equals("title"))
			{
				criteria.setType(type);
				criteria.setKeyword(keyword);
			}
			else if(type.equals("content")) 
			{
				criteria.setType(type);
				criteria.setKeyword(keyword);
			}
			else if(type.equals("user")) 
			{
				criteria.setType(type);
				criteria.setKeyword(keyword);
			}
		}
		
		
		List<NoticeVO> noticeList = noticeService.read(criteria);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
//		List<FreePageVO> freeList = freeService.read(criteria);
//		model.addAttribute("freeList", freeList);
//		
//		List<FoodPageVO> foodList = foodService.read(criteria);
//		model.addAttribute("foodList", foodList);
		
		
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(noticeService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
		
		
		CustomUser custom = new CustomUser();
		try
		{
			String id = princ.getName();
			
			custom = (CustomUser)cuds.loadUserByUsername(id);
			logger.info(custom.toString());
		}
		catch(NullPointerException ne)
		{
			
			logger.info("error");
		}
		
		model.addAttribute("custom", custom);
		
		
		
	} // end list()
	
	
	
	
	// 공지사항 등록
	@GetMapping("/insertNotice")
	public void insertNoticeGET(Model model, Principal princ,
				HttpSession session) throws Exception 
	{
		logger.info("insertNoticeGET()호출 : ");
		
		String id = princ.getName();
		CustomUser custom = (CustomUser)cuds.loadUserByUsername(id);
		model.addAttribute("custom", custom);
		
		
	}
		
		
		
	@PostMapping("/insertNotice")
	public String insertPost(NoticeVO vo, RedirectAttributes reAttr) 
	{
		logger.info("insertPost()호출");
		int result = noticeService.createNotice(vo);
		if(result == 1) 
		{ // DB insert 성공		
			
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/notice/listNotice"; // /food/list 경로로 이동(get)방식
		} 
		else 
		{ // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/notice/insertNotice"; // /food/register 경로로 이동
		}	
	}
	
	@GetMapping("/deleteNotice")
	public String deleteNotice(int noticeNo,
				@ModelAttribute("page") int page) throws Exception 
	{
		logger.info("deleteNotice() 호출 : noticeNo = " + noticeNo);
		int result = noticeService.deleteNotice(noticeNo);
		if(result == 1) 
		{
			return "redirect:/notice/listNotice";
		} 
		else 
		{
			return "redirect:/notice/detailNotice?=noticeNo" + noticeNo;
		}
	}
	
	
	@GetMapping("/detailNotice")
	public void detailNoticeGET(int noticeNo, 
					@ModelAttribute("page") int page,
					Model model, Principal princ) 
	{
		logger.info("detailNotice() 호출 : noticeNo = " + noticeNo);
		logger.info("page = " + page);
		
		
		NoticeVO nvo = noticeService.select(noticeNo);
		logger.info("이전 조회수 : " + nvo.getNoticeViewCnt());
		int cnt = noticeService.updateNoticeViewCnt(noticeNo);
		logger.info("조회수 증가 = " + cnt);
		nvo.setNoticeViewCnt(nvo.getNoticeViewCnt() + cnt);
		logger.info("이후 조회 수 : " + nvo.getNoticeViewCnt());
		
		
		model.addAttribute("NoticeVO", nvo);
		
		
		// 로그인 + 게시물
		CustomUser custom = new CustomUser();
		try
		{
			String userID = princ.getName();
			
			custom = (CustomUser)cuds.loadUserByUsername(userID);
			logger.info(custom.toString());
			
			
		}
		catch(NullPointerException ne)
		{
			
			logger.info("error");
			custom = new CustomUser();
			logger.info(custom.toString());
		}
		
		model.addAttribute("custom", custom);
		
		
		
	}
	
	
	@GetMapping("/updateNotice")
	public void updateNoticeGET(int noticeNo, 
				Model model, Principal princ) throws Exception 
	{
		logger.info("update() 호출 : foodNo = " + noticeNo);
		NoticeVO vo = noticeService.select(noticeNo);
		model.addAttribute("NoticeVO", vo);
	}
	
	
	@PostMapping("/updateNotice")
	public String updateNoticePOST(NoticeVO vo) throws Exception 
	{
		logger.info("updatePOST() 호출 : NoticeNo = " + vo.getNoticeNo());
		int result = noticeService.updateNotice(vo);
		if(result == 1) 
		{
			return "redirect:/notice/listNotice";
		} 
		else 
		{
			return "redirect:/notice/updateNotice?NoticeNo=" + vo.getNoticeNo();
		}
	}
	
	
	
	
	
}
