package edu.spring.travel06.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.security.CustomUserDetailsService;
import edu.spring.travel06.security.domain.CustomUser;
import edu.spring.travel06.service.*;
import edu.spring.travel06.util.*;



@Controller
@RequestMapping(value ="/play") // url : /travel/play/
public class PlayPageController {
	private static final Logger logger = 
			LoggerFactory.getLogger(PlayPageController.class);
	

	@Autowired
	PlayPageService playService;
	
	@Autowired
	PlayReviewService playReview;
	
	
	@Autowired
	CustomUserDetailsService cuds;
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private NoticePageService noticeService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	

	@GetMapping("/list")
	public void list(Model model, Principal princ,
			HttpSession session, String type, String keyword,
			Integer page, Integer perPage) throws Exception 
	{
		logger.info("list 호출");
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
		
		
		
		List<PlayPageVO> list = playService.read(criteria);
		model.addAttribute("playList", list);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
		List<NoticeVO> noticeList = noticeService.select();
		model.addAttribute("noticeList", noticeList);
		
		int totalPage = list.size() + noticeList.size();
		
//		logger.info("좋아요수 :" + list.get(0).getPlayGoodCnt());
//		logger.info("타이틀 :" + list.get(0).getPlayTitle());
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
	
	// 상품 등록

	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void registerGET(Model model, Principal princ,
				HttpSession session) throws Exception 
	{
		logger.info("registerGet()호출 : " + uploadPath);
		
		String id = princ.getName();
		CustomUser custom = (CustomUser)cuds.loadUserByUsername(id);
		model.addAttribute("custom", custom);
		
		

	}
	


	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String registerPost(PlayPageVO vo,MultipartFile file,
						RedirectAttributes reAttr) throws IOException 
	{
		logger.info("registerPost()호출 : " + uploadPath);
		
		logger.info("파일 이름 : " + file.getOriginalFilename());
		logger.info("파일 크기 : " + file.getSize());

		
		String imgUploadPath = FileUploadUtil.getUploadPath(uploadPath + File.separator + "imgUpload");  //  /uploadPath/imgUpload 
		logger.info("imgUploadPath : " + imgUploadPath);
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName =  FileUploadUtil.saveUploadedFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			logger.info("fileName : " + fileName);
			vo.setImg(fileName);

	
			
		} 
		else 
		{ 
			fileName = File.separator + "images" + File.separator + "none.png";

			vo.setImg(fileName);
		}

		int result = playService.create(vo);
		if(result == 1) { // DB insert 성공	
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/play/list"; // /play/list 경로로 이동(get)방식
		} else { // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/play/register"; // /play/register 경로로 이동
		}		
	}
	
	
	
	@GetMapping("/detail")
	public void detailGET(int playNo, Model model, 
				@ModelAttribute("page") int page, 
				HttpSession session, Principal princ) 
	{
		logger.info("detail() 호출 : playNo = " + playNo);
		logger.info("page = " + page);
		PlayPageVO playVO = playService.read(playNo);
		logger.info("이전 조회수 : " + playVO.getPlayViewCnt());
		int count = playService.updatePlayViewCnt(playNo);
		logger.info("조회수 증가 = " + count);
		playVO.setPlayViewCnt(playVO.getPlayViewCnt() + count);
		logger.info("이후 조회 수  : " + playVO.getPlayViewCnt());
		
		model.addAttribute("PlayPageVO", playVO);
		
		
		// 로그인 + 게시물
		CustomUser custom = new CustomUser();
		try
		{
			String userID = princ.getName();
			int mno = 0;
			custom = (CustomUser)cuds.loadUserByUsername(userID);
			logger.info(custom.toString());
			
			if(custom.getUvo() != null)
			{
				mno = custom.getUvo().getUserNo();
				
			}
			if(custom.getAvo() != null)
			{
				mno = custom.getAvo().getAdminNo();
			}
			
			 PlayLikeVO likeVO = new PlayLikeVO();
		     likeVO.setPlayNo(playNo);
		     likeVO.setMno(mno);

		     int playlike = playService.getPlayLike(likeVO);
		     logger.info("먹거리 좋아요 수 : "+playlike);

		     model.addAttribute("heart",playlike);
		     
		     PlayWishVO wishVO = new PlayWishVO();
		     wishVO.setPlayNo(playNo);
		     wishVO.setMno(mno);
		     
		     int playWish = playService.getPlayWish(wishVO);
		     logger.info("찜하기 개수: " + playWish);
		     model.addAttribute("basket", playWish);
		     
			
			
		}
		catch(NullPointerException ne)
		{
			
			logger.info("error");
			custom = new CustomUser();
			logger.info(custom.toString());
		}
		
		model.addAttribute("custom", custom);
		
		
	}
	
	@GetMapping("/update")
	public void updateGET(int playNo, Model model, 
			@ModelAttribute("page") int page, HttpServletRequest request)
	{
		logger.info("update() 호출 : playNo = " + playNo);
		PlayPageVO vo = playService.read(playNo);
		model.addAttribute("PlayPageVO", vo);
	}
	
	@PostMapping("/update")
	public String updatePOST(PlayPageVO vo, int page) throws Exception {
		logger.info("updatePOST() 호출 : playNo = " + vo.getPlayNo());
		int result = playService.update(vo);
		if(result == 1) {
			return "redirect:/play/list?page=" + page;
		} else {
			return "redirect:/play/update?playNo=" + vo.getPlayNo();
		}
	}
	
	@GetMapping("/delete")
	public String delete(int playNo, RedirectAttributes reAttr) throws Exception 
	{
		logger.info("delete() 호출 : playNo = " + playNo);
		
		List<PlayReviewVO> reviewList = playReview.read(playNo);
		for(PlayReviewVO rvo : reviewList)
		{
			logger.info(rvo.toString());
			playReview.delete(rvo.getPlayReviewNo(), playNo);
			
		}
		
		int result = playService.delete(playNo);
		if(result == 1) {
			return "redirect:/play/list";
		} else {
			return "redirect:/play/detail?playNo=" + playNo;
		}
	}
	
	
	@GetMapping("/warning")
	public void UserWarning(Model model, HttpServletResponse response,
					@RequestParam("userNickname") String nickName) throws IOException
	{
		logger.info("user Warning Page : " + nickName);
		
		UserVO uvo = serviceUser.read(nickName);
		if(uvo == null) 
		{
			uvo = new UserVO();
			response.sendRedirect("/travel06/play/list");
		}
		
		logger.info(uvo.toString());
			
		model.addAttribute("UserVO", uvo);
		
		int warn = serviceUser.updateUserWarning(1, uvo.getUserNo());
		logger.info("경고 : " + warn);
		if(warn ==1)
		{
			logger.info("경고 성공");
			response.sendRedirect("/travel06/play/list");
		}
		else
		{
			logger.info("경고 실패 ㅠㅠ");
		}
		
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/heart", method = RequestMethod.POST, produces = "application/json")
	public int heart(HttpServletRequest httpRequest, Principal princi)
	{
		
		int heart = Integer.parseInt(httpRequest.getParameter("heart"));
		int playNo = Integer.parseInt(httpRequest.getParameter("playNo"));
		
		
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
		
		logger.info("먹거리 좋아요 : " + heart);
		
		
		PlayLikeVO PlayLikeVO = new PlayLikeVO();
		
		PlayLikeVO.setPlayNo(playNo);
		PlayLikeVO.setMno(mno);
		
		logger.info(PlayLikeVO.toString());
		
		
		
		if(heart >= 1) 
		{
			playService.deletePlayLike(PlayLikeVO);
			heart = 0;
		} 
		else 
		{
			playService.insertPlayLike(PlayLikeVO);
			heart = 1;
		}
		return heart;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/basket", method = RequestMethod.POST, produces = "application/json")
	public int basket(HttpServletRequest httpRequest, Principal princi)
	{
		
		int basket = Integer.parseInt(httpRequest.getParameter("basket"));
		int playNo = Integer.parseInt(httpRequest.getParameter("playNo"));
		
		
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
		
		PlayWishVO playWishVO = new PlayWishVO();
		
		playWishVO.setPlayNo(playNo);
		playWishVO.setMno(mno);
		
		
		if(basket >= 1) 
		{
			
			playService.deletePlayWish(playWishVO);
			basket = 0;
		} 
		else 
		{
			
			playService.insertPlayWish(playWishVO);
			basket = 1;
		}
		return basket;
	}
	
	
	
	
	
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> display(String fileName) throws IOException
	{
		logger.info("display() 호출 : " + fileName);
		
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		String filePath = uploadPath + fileName;
		in = new FileInputStream(filePath);
		
		// 파일 확장자
		String extension = 
				filePath.substring(filePath.lastIndexOf(".") + 1);
		logger.info("파일 확장자 : " + extension);
		// 응답 헤더(response header)에 Content-Type 설정
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.geMediaType(extension));
		logger.info("Http 헤더 : "+httpHeaders);
		
		// 데이터 전송
		entity = new ResponseEntity<byte[]> (
					IOUtils.toByteArray(in), // 파일에서 읽은 데이터
					httpHeaders, // 응답 헤더
					HttpStatus.OK
				);
		return entity;
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
		
		List<PlayPageVO> list = playService.bestListAll();
		model.addAttribute("playList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(playService.getTotalNumsOfRecords());
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
		
		List<PlayPageVO> list = playService.bestReviewAll();
		model.addAttribute("playList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(playService.getTotalNumsOfRecords());
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
		
		List<PlayPageVO> list = playService.bestGoodAll();
		model.addAttribute("playList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(playService.getTotalNumsOfRecords());
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
		
		List<PlayPageVO> list = playService.bestWishAll();
		model.addAttribute("playList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(playService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
		
		
	} // end bestWish()
	
	
	
	private String saveUploadFile(MultipartFile file) throws Exception 
	{
		// UUID : 업로드하는 파일 이름이 중복되지 않도록
		UUID uuid = UUID.randomUUID();
		String savedName = uuid + "_" + file.getOriginalFilename();
		File target = new File(uploadPath, savedName); // 저장할 파일 객체 생성
		
		try {
			FileCopyUtils.copy(file.getBytes(), target);
			logger.info("파일 저장 성공");
			return savedName;
		} 
		catch (IOException e) 
		{
			logger.error("파일 저장 실패");
			return null;
		}
		
	}
	
	
	
	
}	