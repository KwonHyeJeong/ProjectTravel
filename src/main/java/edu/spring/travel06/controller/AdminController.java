package edu.spring.travel06.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.security.CustomUserDetailsService;
import edu.spring.travel06.security.domain.CustomUser;
import edu.spring.travel06.service.*;
import edu.spring.travel06.domain.*;


@Controller
@RequestMapping(value="/admin")
public class AdminController 
{
	private static final Logger logger = 
			LoggerFactory.getLogger(AdminController.class);
	
	
	@Autowired
	private AdminService serviceAdmin;
	
	@Autowired
	private UserService serviceUser;
	
	
	@Autowired
	private CustomUserDetailsService cuds;
	
	@Autowired
	private FreePageService freeService;
	
	@Autowired
	private FreeReviewService freeReview;
	
	@Autowired
	private FoodPageService foodService;
	
	@Autowired
	private FoodReviewService foodReview;
	
	
	
	@Autowired
	private PlayPageService playService;
	
	@Autowired
	private PlayReviewService playReview;
	
	@Autowired
	private ThemePageService themeService;
	
	@Autowired
	private ThemeReviewService themeReview;
	
	
	@Autowired
	private NoticePageService noticeService;
	
	
	
	@GetMapping("/list")
	public void list(Model model, Integer page, Integer perPage)
	{
		logger.info("administer list");
		
		List<AdminVO> list = serviceAdmin.read();
		for(AdminVO vo : list)
		{
			logger.info("번호 : " + vo.getAdminNo());
			logger.info("이름 : " + vo.getAdminName());
			logger.info("id : " + vo.getAdminID());
			logger.info("휴대폰 : " + vo.getAdminPhone());
			logger.info("회사 전화번호 : " + vo.getAdminCompany());
			logger.info("생일 : " + vo.getAdminBirth());
			
		}
		model.addAttribute("adminList", list);
		
	}
	
	
	
	@GetMapping("/register")
	public void registerGET(Model model)
	{
		logger.info("registerGET() 호출");
		
	}	// end registerGET
	
	
	@PostMapping("/register")
	public String registerPost(
				Model model,
				RedirectAttributes reAttr,
				@ModelAttribute("adminName") String adminName,
				@ModelAttribute("adminID") String adminID,
				@ModelAttribute("adminPWD") String adminPWD,
				@ModelAttribute("adminPhone") String adminPhone,
				@ModelAttribute("adminCompany") String adminCompany,
				@ModelAttribute("adminEmail") String adminEmail,
				@ModelAttribute("adminBirth") String adminBirth
				) throws ParseException
	{
		logger.info("admin registerPost() ");
		
		DateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date birthDay = transFormat.parse(adminBirth);

		logger.info(birthDay + "");
		
		AdminVO avo = new AdminVO(0, adminName, adminID, adminPWD, adminPhone, adminCompany, adminEmail, birthDay);
		
		int result = serviceAdmin.create(avo);
		if(result == 1)
		{
			reAttr.addFlashAttribute("admin_result", "success");
			return "redirect:/main/all";
		}
		else
		{
			reAttr.addFlashAttribute("admin_result", "fail");
			return "redirect:/main/all";
		}
		
		
	}	// end registerPOST()
	
	
	
	@GetMapping("/myInfo")
	public void myInfoGet(Model model, Principal princ,
				HttpSession session
						)
	{
		logger.info("myinfo get() 호출");

		
		CustomUser custom = (CustomUser)cuds.loadUserByUsername(princ.getName());
		model.addAttribute("custom", custom);
		
		
	}
	
	
	@GetMapping("/myPageList")
	public void pageListGET(Model model, Principal principal,
					HttpSession session,
					Integer page, Integer perPage) throws Exception
	{
		logger.info("내가 작성한 글들 보기");
		
		logger.info("page = " + page + ", perPage = " + perPage);
		
		// Paging ó��
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) { 
			criteria.setNumsPerPage(perPage);
		}
		
		
		CustomUser custom = (CustomUser) cuds.loadUserByUsername(principal.getName());
		model.addAttribute("custom", custom);
		
		
		List<FreePageVO> nicknameList = freeService.readByUserNickname(custom.getAvo().getAdminID());
		model.addAttribute("freePageList", nicknameList);
		
		
		List<FoodPageVO> foodNickName = foodService.readByUserNickname(custom.getAvo().getAdminID());
		model.addAttribute("foodPageList", foodNickName);
		
		List<NoticeVO> noticeNickName = noticeService.readByNickName(custom.getAvo().getAdminID());
		model.addAttribute("noticePageList", noticeNickName);
		
		List<PlayPageVO> playNickName = playService.readByUserNickname(custom.getAvo().getAdminID());
		model.addAttribute("playPageList", playNickName);
		
		
		List<ThemePageVO> themeNickName = themeService.readByUserNickname(custom.getAvo().getAdminID());
		model.addAttribute("themePageList", themeNickName);
		
		
		int totalPage = nicknameList.size() + foodNickName.size() + noticeNickName.size()
							+ playNickName.size() + themeNickName.size();
		logger.info("총 개수 : " + totalPage);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(totalPage);
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
	}
	
	@GetMapping("/myReviewList")
	public void reviewListGET(Model model, Principal principal,
					HttpSession session,
					Integer page, Integer perPage
							) throws Exception
	{
		logger.info("내가 작성한 댓글들 보기");
		
		logger.info("page = " + page + ", perPage = " + perPage);
		
		// Paging ó��
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) { 
			criteria.setNumsPerPage(perPage);
		}
		
		
		CustomUser custom = (CustomUser) cuds.loadUserByUsername(principal.getName());
		model.addAttribute("custom", custom);
		
		List<FreeReviewVO> freeList = freeReview.readbyUser(custom.getAvo().getAdminID());
		model.addAttribute("freeReviewList", freeList);
		
		List<FoodReviewVO> foodList = foodReview.readbyUser(custom.getAvo().getAdminID());
		model.addAttribute("foodReviewList", foodList);
		
		
		List<PlayReviewVO> playList = playReview.readbyUser(custom.getAvo().getAdminID());
		model.addAttribute("playReviewList", playList);
		
		List<ThemeReviewVO> themeList = themeReview.readbyUser(custom.getAvo().getAdminID());
		model.addAttribute("themeReviewList", themeList);
		
		
		int totalPage = freeList.size() + foodList.size() 
						+ playList.size() + themeList.size();
		logger.info("총 개수 : " + totalPage);
		
		
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(totalPage);
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
	}
	
	
	
	@GetMapping("/likeList")
	public void likeList(Model model, HttpSession session, 
						Integer page, Integer perPage, Principal princi) 
	{

		logger.info("likeList 호출");
		
		CustomUser custom = new CustomUser();
		
		String id = princi.getName();
		logger.info("principal id = " + id);
		
		AdminVO avo = serviceAdmin.read(id);
		model.addAttribute("AdminVO", avo);
		
		
		int mno = avo.getAdminNo();
		
		List<BoardLikeVO> freeLikeList = freeService.selectLike(mno);
		int likeList[] = new int[1000];
		List<FreePageVO> freeList1 = new ArrayList<FreePageVO>();
		List<FreePageVO> freeList2 = new ArrayList<FreePageVO>();
		
		for(int i = 0; i < freeLikeList.size(); i++) 
		{
			likeList[i] = freeLikeList.get(i).getBoardno();
			logger.info("likeList" + likeList[i]);
		}
		
		for(int i = 0; i < freeLikeList.size(); i++) {
			freeList2 = freeService.selectBoardLike(likeList[i]);
			freeList1.addAll(freeList2);
		}
		logger.info("mylist 사이즈: " + freeList1.size());
		
		model.addAttribute("freePageList",freeList1);
		
		
		
		List<FoodLikeVO> foodLikeList = foodService.selectLike(mno);
		List<FoodPageVO> foodList1 = new ArrayList<FoodPageVO>();
		List<FoodPageVO> foodList2 = new ArrayList<FoodPageVO>();
		
		for(int i = 0; i < foodLikeList.size(); i++) 
		{
			likeList[i] = foodLikeList.get(i).getFoodNo();
			logger.info("likeList" + likeList[i]);
		}
		
		for(int i = 0; i < foodLikeList.size(); i++) 
		{
			foodList2 = foodService.selectFoodLike(likeList[i]);
			foodList1.addAll(foodList2);
		}
		logger.info("mylist 사이즈: " + foodList1.size());
		
		model.addAttribute("foodList",foodList1);
		
		
		List<PlayLikeVO> playLikeList = playService.selectLike(mno);
		List<PlayPageVO> playList1 = new ArrayList<PlayPageVO>();
		List<PlayPageVO> playList2 = new ArrayList<PlayPageVO>();
		for(int i = 0; i < playLikeList.size(); i++) 
		{
			likeList[i] = playLikeList.get(i).getPlayNo();
			logger.info("likeList" + likeList[i]);
		}
		
		for(int i = 0; i < playLikeList.size(); i++) {
			playList2 = playService.selectPlayLike(likeList[i]);
			playList1.addAll(playList2);
		}
		logger.info("mylist 사이즈: " + playList1.size());
		
		model.addAttribute("playList",playList1);
		
		
		List<ThemeLikeVO> themeLikeList = themeService.selectLike(mno);
		List<ThemePageVO> themeList1 = new ArrayList<ThemePageVO>();
		List<ThemePageVO> themeList2 = new ArrayList<ThemePageVO>();
		for(int i = 0; i < themeLikeList.size(); i++) 
		{
			likeList[i] = themeLikeList.get(i).getThemaNo();
			logger.info("likeList" + likeList[i]);
		}
		
		for(int i = 0; i < themeLikeList.size(); i++) 
		{
			themeList2 = themeService.selectThemeLike(likeList[i]);
			themeList1.addAll(themeList2);
		}
		logger.info("mylist 사이즈: " + themeList1.size());
		
		model.addAttribute("themeList",themeList1);
		
		
		
		int totalPage = freeList1.size() + foodList1.size() 
						+ playList1.size() + themeList1.size();
		
		
		logger.info("총 개수 : " + totalPage);
		
		
		logger.info("page = " + page + ", perPage = " + perPage);
		
		// Paging ó��
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (perPage != null) { 
			criteria.setNumsPerPage(perPage);
		}
		
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(totalPage);
		maker.setPageData();
		model.addAttribute("pageMaker", maker);

	} // end list()
	
	
	
	@GetMapping("/wishList")
	public void wishList(Model model, HttpSession session, 
				Integer page, Integer perPage, Principal princi) 
	{

		logger.info("wishList 호출");
		
		
		String id = princi.getName();
		logger.info("principal id = " + id);
		
		AdminVO avo = serviceAdmin.read(id);
		model.addAttribute("AdminVO", avo);
		
		
		int mno = avo.getAdminNo();
		
		
		List<FreeWishVO> freeWishList = freeService.selectWish(mno);
		int wishList[] = new int[1000];
		List<FreePageVO> myList = new ArrayList<FreePageVO>();
		List<FreePageVO> myList2 = new ArrayList<FreePageVO>();
		
		for(int i = 0; i < freeWishList.size(); i++) 
		{
			wishList[i] = freeWishList.get(i).getFreeNo();
			logger.info("wishList" + wishList[i]);
		}
		
		for(int i = 0; i < freeWishList.size(); i++)
		{
			myList2 = freeService.selectFreeWish(wishList[i]);
			myList.addAll(myList2);
		}
		logger.info("mylist 사이즈" + myList.size());
		
		model.addAttribute("freeList",myList);
		
		
		
		List<FoodWishVO> foodWishList = foodService.selectWish(mno);
		List<FoodPageVO> foodList1 = new ArrayList<FoodPageVO>();
		List<FoodPageVO> foodList2 = new ArrayList<FoodPageVO>();
		
		for(int i = 0; i < foodWishList.size(); i++) 
		{
			wishList[i] = foodWishList.get(i).getFoodNo();
			logger.info("wishList" + wishList[i]);
		}
		
		for(int i = 0; i < foodWishList.size(); i++) 
		{
			foodList2 = foodService.selectFoodLike(wishList[i]);
			foodList1.addAll(foodList2);
		}
		logger.info("mylist 사이즈: " + foodList1.size());
		
		model.addAttribute("foodList",foodList1);
		
		
		List<PlayWishVO> playWishList = playService.selectWish(mno);
		List<PlayPageVO> playList1 = new ArrayList<PlayPageVO>();
		List<PlayPageVO> playList2 = new ArrayList<PlayPageVO>();
		
		for(int i = 0; i < playWishList.size(); i++) 
		{
			wishList[i] = playWishList.get(i).getPlayNo();
			logger.info("wishList" + wishList[i]);
		}
		
		for(int i = 0; i < playWishList.size(); i++) 
		{
			playList2 = playService.selectPlayLike(wishList[i]);
			playList1.addAll(playList2);
		}
		logger.info("mylist 사이즈: " + playList1.size());
		
		model.addAttribute("playPageList",playList1);
		
		
		
		List<ThemeWishVO> themeWishList = themeService.selectWish(mno);
		List<ThemePageVO> themeList1 = new ArrayList<ThemePageVO>();
		List<ThemePageVO> themeList2 = new ArrayList<ThemePageVO>();
		
		for(int i = 0; i < themeWishList.size(); i++) 
		{
			wishList[i] = themeWishList.get(i).getThemaNo();
			logger.info("wishList" + wishList[i]);
		}
		
		for(int i = 0; i < themeWishList.size(); i++) 
		{
			themeList2 = themeService.selectThemeLike(wishList[i]);
			themeList1.addAll(themeList2);
		}
		logger.info("mylist 사이즈: " + themeList1.size());
		
		model.addAttribute("themePageList",themeList1);
		
		
		int totalPage = myList.size() + foodList1.size()
		+ playList1.size() + themeList1.size();
		logger.info("찜 목록 총 개수 : " + totalPage);
		
		
		logger.info("page = " + page + ", perPage = " + perPage);
		
		// Paging ó��
		PageCriteria criteria = new PageCriteria();
		if (page != null) 
		{
			criteria.setPage(page);
		}
		if (perPage != null) 
		{ 
			criteria.setNumsPerPage(perPage);
		}
		
		
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(totalPage);
		maker.setPageData();
		model.addAttribute("pageMaker", maker);

	} // end wishList()
	
	
	
	
	
	
	
	
	// 강제 탈퇴
	@GetMapping("user_delete_confirm")
	public void deleteConfirmGET(Model model,
						@RequestParam("adminID") String userID
							)
	{
		
		logger.info(userID + "님 정말로 탈퇴하실 건가요?");
		
		UserVO uvo = serviceUser.read(userID);
		
		model.addAttribute("UserVO", uvo);
		
	}
	
	
	@PostMapping("/user_delete_confirm")
	public String deletePOST(Model model,
						@ModelAttribute("userID") String id,
						RedirectAttributes reAttr
						)
	{
		logger.info("강제 탈퇴 : " + id);
		
		UserVO uvo = serviceUser.read(id);
		
		int userDelete;
		
		int freePageDelete,freeReviewDelete;
		int foodPageDelete, foodReviewDelete;
		int playPageDelete, playReviewDelete;
		int themePageDelete, themeReviewDelete;
		
		
		List<FreePageVO> fList = freeService.readByUserNickname(uvo.getUserNickName());
		for(FreePageVO fvo : fList)
		{
			logger.info("게시판 번호: "+fvo.getFreeNo());
			freePageDelete = freeService.delete(fvo.getFreeNo());
			if(freePageDelete == 1)
			{
				logger.info("작성한 게시글들이 삭제되었습니다.");
			}
			
		}
		
		
		List<FreeReviewVO> reviewFree = freeReview.readbyUser(uvo.getUserNickName());
		for(FreeReviewVO rvo : reviewFree)
		{
			logger.info("작성한 free 댓글들");
			try 
			{
				freeReviewDelete = freeReview.delete(rvo.getFreeReviewNo(), rvo.getFreeNo());
				logger.info("작성한 free 댓글들 삭제 성공!");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("free 댓글 삭제 error");
			}
			
			
		}
		
		
		List<FoodPageVO> foodList = foodService.readByUserNickname(uvo.getUserNickName());
		for(FoodPageVO foodVO : foodList)
		{
			logger.info("게시판 번호: "+foodVO.getFoodNo());
			foodPageDelete = foodService.delete(foodVO.getFoodNo());
			if(foodPageDelete == 1)
			{
				logger.info("작성한 음식 게시글들이 삭제되었습니다.");
			}
			
		}
		
		List<FoodReviewVO> foodReviewList = foodReview.readbyUser(uvo.getUserNickName());
		for(FoodReviewVO rvo : foodReviewList)
		{
			logger.info("작성한 음식 댓글들 : " + rvo.getFoodReviewContent());
			
			try 
			{
				foodReviewDelete = freeReview.delete(rvo.getFoodReviewNo(), rvo.getFoodNo());
				logger.info("작성한 음식 댓글들 삭제 성공!");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("음식 댓글 삭제 error");
			}
			
			
		}
		
		
		List<PlayPageVO> playList = playService.readByUserNickname(uvo.getUserNickName());
		for(PlayPageVO pvo : playList)
		{
			logger.info("게시판 번호: "+pvo.getPlayNo());
			playPageDelete = playService.delete(pvo.getPlayNo());
			if(playPageDelete == 1)
			{
				logger.info("작성한 놀거리 게시글들이 삭제되었습니다.");
			}
			
		}
		
		List<PlayReviewVO> playReviewList = playReview.readbyUser(uvo.getUserNickName());
		for(PlayReviewVO rvo : playReviewList)
		{
			logger.info("작성한 댓글들 : " + rvo.getPlayReviewContent());
			
			try 
			{
				playReviewDelete = freeReview.delete(rvo.getPlayReviewNo(), rvo.getPlayNo());
				logger.info("작성한 놀거리 댓글들 삭제 성공!");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("놀거리 댓글 삭제 error");
			}
			
			
		}
		
		
		
		List<ThemePageVO> themeList = themeService.readByUserNickname(uvo.getUserNickName());
		for(ThemePageVO themeVO : themeList)
		{
			logger.info("게시판 번호: "+themeVO.getThemaNo());
			themePageDelete = themeService.delete(themeVO.getThemaNo());
			if(themePageDelete == 1)
			{
				logger.info("테마 게시글들이 삭제되었습니다.");
			}
			
		}
		
		List<ThemeReviewVO> themeReviewList = themeReview.readbyUser(uvo.getUserNickName());
		for(ThemeReviewVO rvo : themeReviewList)
		{
			logger.info("테마 댓글들 : " + rvo.getThemaReviewContent());
			
			try 
			{
				themeReviewDelete = themeReview.delete(rvo.getThemaReviewNo(), rvo.getThemaNo());
				logger.info("테마 댓글들 삭제 성공!");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("테마 댓글 삭제 error");
			}
			
			
		}
		
		
		
		
		userDelete = serviceUser.delete(id);
		if(userDelete == 1)
		{
			logger.info("회원님이 정상적으로 탈퇴되었습니다.");
			reAttr.addFlashAttribute("userDeleteResult", "success");
			return "redirect:/main/all";
		}
		else 
		{
			logger.info("회원 탈퇴 실패");
			reAttr.addFlashAttribute("userDeleteResult", "fail");
			return "redirect:/user/list";
		}
		
		
	}
	
	
	// 관리자 탈퇴
	@GetMapping("delete-confirm")
	public void deleteConfirmGET(Model model,
							Principal princ
							)
	{
		
		String name = princ.getName();
		logger.info(name + "님 정말로 탈퇴하실 건가요?");
		
		CustomUser custom = new CustomUser();
		custom = (CustomUser)cuds.loadUserByUsername(name);
		logger.info(custom.toString());
		model.addAttribute("custom", custom);
		
	}
	
	
	@PostMapping("/delete-confirm")
	public String confirmPost(Model model,
						Principal princ,
						RedirectAttributes reAttr)
	{
		logger.info("관리자 탈퇴");
		String userid = princ.getName();
		
		AdminVO avo = serviceAdmin.read(userid);
		
		int voDelete;
		
		int freeDelete, freeReviewDelete;
		int foodPageDelete, foodReviewDelete;
		int playPageDelete, playReviewDelete;
		int themePageDelete, themeReviewDelete;
		
		
		
		List<FreePageVO> fList = freeService.readByUserNickname(avo.getAdminID());
		for(FreePageVO fvo : fList)
		{
			logger.info("게시판 번호: "+fvo.getFreeNo());
			freeDelete = freeService.delete(fvo.getFreeNo());
			if(freeDelete == 1)
			{
				logger.info("작성한 게시글들이 삭제되었습니다.");
			}
			
		}
		
		List<FreeReviewVO> reviewList = freeReview.readbyUser(avo.getAdminID());
		for(FreeReviewVO rvo : reviewList)
		{
			logger.info("작성한 댓글들 : " + rvo.getFreeReviewContent());
			
			try 
			{
				freeReviewDelete = freeReview.delete(rvo.getFreeReviewNo(), rvo.getFreeNo());
				logger.info("작성한 댓글들 삭제 성공!");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("댓글 삭제 error");
			}
			
			
		}
		
		List<FoodPageVO> foodList = foodService.readByUserNickname(avo.getAdminID());
		for(FoodPageVO foodVO : foodList)
		{
			logger.info("게시판 번호: "+foodVO.getFoodNo());
			foodPageDelete = foodService.delete(foodVO.getFoodNo());
			if(foodPageDelete == 1)
			{
				logger.info("작성한 음식 게시글들이 삭제되었습니다.");
			}
			
		}
		
		List<FoodReviewVO> foodReviewList = foodReview.readbyUser(avo.getAdminID());
		for(FoodReviewVO rvo : foodReviewList)
		{
			logger.info("작성한 음식 댓글들 : " + rvo.getFoodReviewContent());
			
			try 
			{
				foodReviewDelete = freeReview.delete(rvo.getFoodReviewNo(), rvo.getFoodNo());
				logger.info("작성한 음식 댓글들 삭제 성공!");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("음식 댓글 삭제 error");
			}
			
			
		}
		
		
		List<PlayPageVO> playList = playService.readByUserNickname(avo.getAdminID());
		for(PlayPageVO pvo : playList)
		{
			logger.info("게시판 번호: "+pvo.getPlayNo());
			playPageDelete = playService.delete(pvo.getPlayNo());
			if(playPageDelete == 1)
			{
				logger.info("작성한 놀거리 게시글들이 삭제되었습니다.");
			}
			
		}
		
		List<PlayReviewVO> playReviewList = playReview.readbyUser(avo.getAdminID());
		for(PlayReviewVO rvo : playReviewList)
		{
			logger.info("작성한 댓글들 : " + rvo.getPlayReviewContent());
			
			try 
			{
				playReviewDelete = freeReview.delete(rvo.getPlayReviewNo(), rvo.getPlayNo());
				logger.info("작성한 놀거리 댓글들 삭제 성공!");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("놀거리 댓글 삭제 error");
			}
			
			
		}
		
		
		
		List<ThemePageVO> themeList = themeService.readByUserNickname(avo.getAdminID());
		for(ThemePageVO themeVO : themeList)
		{
			logger.info("게시판 번호: "+themeVO.getThemaNo());
			themePageDelete = themeService.delete(themeVO.getThemaNo());
			if(themePageDelete == 1)
			{
				logger.info("테마 게시글들이 삭제되었습니다.");
			}
			
		}
		
		List<ThemeReviewVO> themeReviewList = themeReview.readbyUser(avo.getAdminID());
		for(ThemeReviewVO rvo : themeReviewList)
		{
			logger.info("테마 댓글들 : " + rvo.getThemaReviewContent());
			
			try 
			{
				themeReviewDelete = themeReview.delete(rvo.getThemaReviewNo(), rvo.getThemaNo());
				logger.info("테마 댓글들 삭제 성공!");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("테마 댓글 삭제 error");
			}
			
			
		}
		
		
		
		
		voDelete = serviceAdmin.delete(userid);
		if(voDelete == 1)
		{
			logger.info("관리자님이 정상적으로 탈퇴되었습니다.");
			reAttr.addFlashAttribute("adminDeleteResult", "success");
			return "redirect:/main/all";
		}
		else 
		{
			logger.info("관리자 탈퇴 실패");
			reAttr.addFlashAttribute("adminDeleteResult", "fail");
			return "redirect:/admin/myInfo";
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
