package edu.spring.travel06.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.helpers.PrintConversionEventImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.*;

import edu.spring.travel06.pageutil.PageCriteria;
import edu.spring.travel06.pageutil.PageMaker;
import edu.spring.travel06.persistance.FreePageDAO;
import edu.spring.travel06.security.CustomUserDetailsService;
import edu.spring.travel06.security.domain.CustomUser;
import edu.spring.travel06.service.*;



@Controller
@RequestMapping(value= "/free") // url : /travel/free/
public class FreePageController 
{
	private static final Logger logger = 
			LoggerFactory.getLogger(FreePageController.class);
	
	@Autowired
	private FreePageService freeService;
	
	@Autowired
	private UserService serviceUser;
	
	
	@Autowired
	CustomUserDetailsService cuds;
	
	@Autowired
	private FreeReviewService freeReviewService;
	
	@Autowired
	private NoticePageService noticeService;
	
	@Autowired
	private AdminService serviceAdmin;
	
	
	@GetMapping("/free_page_list")
	public void list(Model model, Principal princ,
			HttpSession session, String type, String keyword,
			Integer page, Integer perPage) 
	{
		logger.info("free_page_list ȣ��");
		logger.info("type = " + type + ", keyword = " + keyword);
		
		
		// Paging ó��
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
			
		}
		if(perPage != null) 
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
		
		
		
		List<FreePageVO> list = freeService.read(criteria);
		model.addAttribute("freeList", list);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
		
		List<NoticeVO> noticeList = noticeService.select();
		model.addAttribute("noticeList", noticeList);
		
		int totalPage = list.size() + noticeList.size();
		
		
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(totalPage);
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
	
	@GetMapping("/free_page_register")
	@PreAuthorize("isAuthenticated()")
	public void registerGET(Model model, Principal princ,
					HttpSession session) 
	{ // free_page_list.jsp�� �̵�
		logger.info("registerGET() ȣ��");
		String id = princ.getName();
		CustomUser custom = (CustomUser)cuds.loadUserByUsername(id);
		model.addAttribute("custom", custom);

		
		
	} // end registerGET()
	
	@PostMapping("/free_page_register")
	@PreAuthorize("isAuthenticated()")
	public String registerPOST(FreePageVO vo, RedirectAttributes reAttr) 
	{ // free_register.jsp�� action�� post�̹Ƿ�
		logger.info("registerPOST() ȣ��");
		logger.info(vo.toString());
		int result = freeService.create(vo);
		if(result == 1) { // DB insert ����
			// "insert_result"�� Ű�̸��� ���� ������ ����
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/free/free_page_list"; //  /free/free_page_list ��η� �̵�(get)��� 
		} else { // DB insert ����
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/free/free_page_list"; // /free/free_page_register ��η� �̵�
		}
	} // end registerPOST()
	
	
	@GetMapping("/free_page_detail")
	public void detailGET(int freeNo, Model model, 
					@ModelAttribute("page") int page,
					HttpSession session, Principal princ
					) 
	{
		logger.info("detail() ȣ�� : freeNo = " + freeNo);
		
	
		FreePageVO freeVO = freeService.read(freeNo);
		
		logger.info("이전 조회수 : " + freeVO.getFreeViewCnt());
		int count = freeService.updateFreeViewCnt(1, freeNo);
		logger.info("조회수 증가 = " + count);
		freeVO.setFreeViewCnt(freeVO.getFreeViewCnt() + count);
		logger.info("이후 조회 수  : " + freeVO.getFreeViewCnt());
		
		model.addAttribute("FreePageVO", freeVO);
		
		// 로그인 + 게시물
		CustomUser custom = new CustomUser();
		try
		{
			String id = princ.getName();
			int mno = 0;
			custom = (CustomUser)cuds.loadUserByUsername(id);
			logger.info(custom.toString());
			
			if(custom.getUvo() != null)
			{
				mno = custom.getUvo().getUserNo();
				
			}
			if(custom.getAvo() != null)
			{
				mno = custom.getAvo().getAdminNo();
			}
			
			
			BoardLikeVO likeVO = new BoardLikeVO();
	        likeVO.setBoardno(freeNo);
	        likeVO.setMno(mno);
	        logger.info(likeVO.toString());
	        
	        int boardlike = freeService.getBoardLike(likeVO);
	        logger.info("좋아요 개수 : "+boardlike);
	        
	        model.addAttribute("heart",boardlike);
	        
	        
	        FreeWishVO wishVO = new FreeWishVO();
		    wishVO.setFreeNo(freeNo);
		    wishVO.setMno(mno);
		    int freewish = freeService.getFreeWish(wishVO);
		    logger.info("찜하기 개수 : "+freewish);
		    
		    model.addAttribute("basket",freewish);
	        
	        
			
		}
		catch(NullPointerException ne)
		{
			
			logger.info("error");
			custom = new CustomUser();
			logger.info(custom.toString());
		}
		
		model.addAttribute("custom", custom);
		
	} // end detailGET()
	
	@GetMapping("/free_page_update")
	public void updateGET(int freeNo, Model model, 
				@ModelAttribute("page") int page,
				HttpServletRequest request
				) 
	{
		logger.info("free_page_update() ȣ�� : freeNo = " + freeNo);
		
		FreePageVO vo = freeService.read(freeNo);
		
		model.addAttribute("FreePageVO", vo);
		
		
		
	} // end updateGET()
	
	@PostMapping("/free_page_update")
	public String updatePOST(FreePageVO vo, int page) 
	{
		logger.info("updatePOST() ȣ�� : freeNo = " + vo.getFreeNo());
		int result = freeService.update(vo);
		if(result == 1) { 
			return "redirect:/free/free_page_list?page = " + page;
		} else {
			return "redirect:/free/free_page_update?freeNo = " + vo.getFreeNo();
		}
	} // end updatePOST()
	
	
	@GetMapping("/free_page_delete")
	public String delete(int freeNo, RedirectAttributes reAttr) throws Exception
	{
		logger.info("free_page_delete() ȣ�� : freeNo = " + freeNo);
		List<FreeReviewVO> reviewList = freeReviewService.read(freeNo);
		for(FreeReviewVO rvo : reviewList)
		{
			logger.info(rvo.toString());
			freeReviewService.delete(rvo.getFreeReviewNo(), freeNo);
			
		}
		
		
		int result = freeService.delete(freeNo);
		if(result == 1) 
		{
			return "redirect:/free/free_page_list";
		} 
		else 
		{
			return "redirect:/free/free_page_detail?freeNo = " + freeNo;
		}
	}
	
	@GetMapping("/error_page")
	public void errorPageGet()
	{
		logger.info("error page");
		
	}
	
	@GetMapping("/warning")
	public void warningPage(Model model, HttpServletResponse response,
					@RequestParam("userNickname") String nickName) 
					throws IOException
	{
		logger.info("user Warning Page : " + nickName);
		
		
		UserVO uvo = serviceUser.read(nickName);
		if(uvo == null) 
		{
			uvo = new UserVO();
			response.sendRedirect("/travel06/free/free_page_list");
		}
		
		logger.info(uvo.toString());
			
		model.addAttribute("UserVO", uvo);
		
		
		
		int warn = serviceUser.updateUserWarning(1, uvo.getUserNo());
		logger.info("경고 : " + warn);
		if(warn ==1)
		{
			logger.info("경고 성공");
			response.sendRedirect("/travel06/free/free_page_list");
		}
		else
		{
			logger.info("경고 실패 ㅠㅠ");
		}
		
		
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/heart", method = RequestMethod.POST, produces = "application/json")
	public int heart(HttpServletRequest httpRequest,
						Principal princi) throws Exception
	{
		
		int heart = Integer.parseInt(httpRequest.getParameter("heart"));
		int boardno = Integer.parseInt(httpRequest.getParameter("boardno"));
		
		CustomUser custom = new CustomUser();
		
		String id = princi.getName();
		logger.info("principal id = " + id);
		int mno = 0;
		custom = (CustomUser)cuds.loadUserByUsername(id);
		logger.info(custom.toString());
		
		if(custom.getUvo() != null)
		{
			mno = custom.getUvo().getUserNo();
			
		}
		if(custom.getAvo() != null)
		{
			mno = custom.getAvo().getAdminNo();
		}
		
		logger.info("좋아요 : "+heart);
		
		BoardLikeVO boardLikeVO = new BoardLikeVO();
		
		boardLikeVO.setBoardno(boardno);
		boardLikeVO.setMno(mno);
		logger.info(boardLikeVO.toString());
		
		
		if(heart >= 1) 
		{
			freeService.deleteBoardLike(boardLikeVO);
			heart = 0;
		} 
		else 
		{
			freeService.insertBoardLike(boardLikeVO);
			
			heart = 1;
		}
		return heart;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/basket", method = RequestMethod.POST, produces = "application/json")
	public int basket(HttpServletRequest httpRequest, Principal princi)
	{
		
		int basket = Integer.parseInt(httpRequest.getParameter("basket"));
		int boardno = Integer.parseInt(httpRequest.getParameter("boardno"));
		
		
		CustomUser custom = new CustomUser();
		
		String id = princi.getName();
		logger.info("principal id = " + id);
		int mno = 0;
		
		custom = (CustomUser)cuds.loadUserByUsername(id);
		logger.info(custom.toString());
		
		if(custom.getUvo() != null)
		{
			mno = custom.getUvo().getUserNo();
			
		}
		if(custom.getAvo() != null)
		{
			mno = custom.getAvo().getAdminNo();
		}
		
		logger.info("먹거리 찜하기 : " + basket);
		
		FreeWishVO freeWishVO = new FreeWishVO();
		
		freeWishVO.setFreeNo(boardno);
		freeWishVO.setMno(mno);
		
		System.out.println(basket);
		
		if(basket >= 1) 
		{
			freeService.deleteFreeWish(freeWishVO);
			basket = 0;
		} 
		else 
		{
			freeService.insertFreeWish(freeWishVO);
			basket = 1;
		}
		return basket;
	}
	
	
	@GetMapping("/bestList")
	public void bestList(Model model, Integer page, Integer perPage, 
			HttpSession session) throws Exception 
	{
		logger.info("bestList 호출");
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
		
		List<FreePageVO> list = freeService.bestListAll();
		model.addAttribute("freeList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(freeService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
		
		
	} // end bestList()
	
	@GetMapping("/bestReview")
	public void bestReview(Model model, Integer page, Integer perPage, 
				HttpSession session) throws Exception 
	{
		logger.info("bestReview 호출");
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
		
		List<FreePageVO> list = freeService.bestReviewAll();
		model.addAttribute("freeList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(freeService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
		
		
	} // end bestReview()
	
	@GetMapping("/bestGood")
	public void bestGood(Model model, Integer page, Integer perPage, HttpSession session) throws Exception {
		logger.info("bestGood 호출");
		logger.info("page = " + page + ", perPage = " + perPage);
		
		// Paging 처리
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) { 
			criteria.setNumsPerPage(perPage);
		}
		
		List<FreePageVO> list = freeService.bestGoodAll();
		model.addAttribute("freeList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(freeService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
		
		
	} // end bestGood()
	
	@GetMapping("/bestWish")
	public void bestWish(Model model, Integer page, Integer perPage, HttpSession session) throws Exception {
		logger.info("bestWish 호출");
		logger.info("page = " + page + ", perPage = " + perPage);
		
		// Paging 처리
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) { 
			criteria.setNumsPerPage(perPage);
		}
		
		List<FreePageVO> list = freeService.bestWishAll();
		model.addAttribute("freeList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(freeService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
		
		
	} // end bestWish()
	
	
	
	

}
