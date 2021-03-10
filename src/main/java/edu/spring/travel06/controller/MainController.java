package edu.spring.travel06.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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


import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.PageCriteria;
import edu.spring.travel06.pageutil.PageMaker;
import edu.spring.travel06.security.*;
import edu.spring.travel06.security.domain.*;
import edu.spring.travel06.service.*;


@RequestMapping(value="/main/*")
@Controller
public class MainController 
{
	private static final Logger logger = 
			LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	FreePageService freeService;
	
	@Autowired
	CustomUserDetailsService cuds;
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private AdminService serviceAdmin;
	
	
	@Autowired
	private VisitCountService visitCountService;
	
	
	
	@GetMapping("/all")
	public void doAll(Model model, Principal princi)
	{
		logger.info("access everybody");
		
		logger.info("Main()");
//		logger.info("page = " + page + ", perPage = " + perPage);
//		
//		// Paging ó��
//		PageCriteria criteria = new PageCriteria();
//		if(page != null) 
//		{
//			criteria.setPage(page);
//		}
//		if(perPage != null) 
//		{
//			criteria.setNumsPerPage(perPage);
//		}
//		
//		List<FreePageVO> list = freeService.read(criteria);
//		model.addAttribute("freeList", list);
//		
//		PageMaker maker = new PageMaker();
//		maker.setCriteria(criteria);
//		maker.setTotalCount(freeService.getTotalNumsOfRecords());
//		maker.setPageData();
//		model.addAttribute("pageMaker", maker);
		
		CustomUser custom = new CustomUser();
		
		try
		{
			custom = (CustomUser)cuds.loadUserByUsername(princi.getName());
			model.addAttribute("custom", custom);
		}
		catch(NullPointerException ne)
		{
			ne.getStackTrace();
			custom = new CustomUser();
		}
		
		
		VisitCountVO visitVO = new VisitCountVO();
		visitCountService.insertVisit(visitVO);
		
		int visit1 = visitCountService.totalVisit(visitVO);

        

		model.addAttribute("visit1", visit1);
		logger.info("총 방문자수 : "+visit1);
		
		int visit2 = visitCountService.todayVisit(visitVO);

		model.addAttribute("visit2", visit2);
		logger.info("오늘 방문자수 : "+visit2);
		
		
		
	}
	
	@GetMapping("/user")
	public void doUser(Model model, Principal prin)
	{
		logger.info("login member");
		
		
		CustomUser custom = (CustomUser) cuds.loadUserByUsername(prin.getName());
		logger.info(custom.toString());
		model.addAttribute("custom", custom);
		
	}
	
	
	@GetMapping("/admin")
	public void doAdmin(Model model, Principal prin)
	{
		logger.info("administer only");
		
		CustomUser custom = (CustomUser) cuds.loadUserByUsername(prin.getName());
		logger.info(custom.toString());
		model.addAttribute("custom", custom);
		
		
	}
	
	
	// 사용자 ID 찾기
	@GetMapping("/finduserID")
	public void findIDGET()
	{
		logger.info("user id 찾기");
		
	}
	
	@PostMapping("/finduserID")
	public String findIDPost(
					RedirectAttributes reAttr,
					Model model,
					@ModelAttribute("userName") String userName,
					@ModelAttribute("userBirth") String userBirth,
					@ModelAttribute("userPhone") String userPhone
					)
	{
		logger.info("find Post()");
		
		DateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");

		Date birthDay;
		String findStr = "";
		try 
		{
			birthDay = transFormat.parse(userBirth);
			logger.info(birthDay.toString());
			List<UserVO> find = serviceUser.read();
			
			logger.info(find.size()+"");
			
	
			for(UserVO vo : find)
			{

				
				if(vo.getUserName().equals(userName) == true)
				{
					
					if(vo.getUserBirth().equals(birthDay) == true)
					{
						
						if(vo.getUserPhone().equals(userPhone) == true)
						{
							logger.info("id : " + vo.getUserID() + ", 별명 : " + vo.getUserNickName());
							findStr = vo.getUserID();
							reAttr.addFlashAttribute("findOK", findStr);
							return "redirect:/main/finduserID-result";
						}
						
					}
					
				}
				
				
			}
			
			
			
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("date 형식 오류");
		}
		
		return "redirect:/main/finduserID-result";
		
	}
	
	@GetMapping("/finduserID-result")
	public void idResultGET()
	{
		logger.info("id result");
		
		
	}
	
	@GetMapping("/finduserPWD")
	public void findPWDGET()
	{
		logger.info("비밀번호 찾기");
		
	}
	
	@PostMapping("/finduserPWD")
	public String findPWDPost(Model model, 
					RedirectAttributes reAttr,
					@ModelAttribute("userName") String name,
					@ModelAttribute("userID") String id
					)
	{
		logger.info("find Password Post");
		
		List<UserVO> pwdList = serviceUser.read();
		String findStr = "";
		for(UserVO uvo : pwdList)
		{
			if((uvo.getUserName().equals(name) == true) && 
					 (uvo.getUserID().equals(id) == true))
			{
				logger.info("비밀번호는 " + uvo.getUserPWD() + "입니다.");
				findStr = uvo.getUserPWD();
				reAttr.addFlashAttribute("findOK", findStr);
				return "redirect:/main/finduserPWD-result";
			}
			
		}
		
		return "redirect:/main/finduserPWD-result";
		
	}
	
	@GetMapping("/finduserPWD-result")
	public void pwdResultGET()
	{
		logger.info("비밀번호 찾기 결과");
		
	}
	
	
	// 관리자 ID 찾기
	@GetMapping("/findAdminID")
	public void findAdminIDGET()
	{
		logger.info("관리자 id 찾기");
		
	}
	
	@PostMapping("/findAdminID")
	public String findAdminIDPost(
					RedirectAttributes reAttr,
					Model model,
					@ModelAttribute("adminName") String adminName,
					@ModelAttribute("adminPhone") String adminPhone,
					@ModelAttribute("adminCompany") String adminCompany
					)
	{
		logger.info("find Post()");
		List<AdminVO> findAdmin = serviceAdmin.read();
		
		String findStr ="";
		
		for(AdminVO avo : findAdmin)
		{
			
			if(avo.getAdminName().equals(adminName) == true)
			{
				
				if(avo.getAdminPhone().equals(adminPhone) == true)
				{
					
					if(avo.getAdminCompany().equals(adminCompany) == true)
					{
						logger.info("id : " + avo.getAdminID());
						findStr = avo.getAdminID();
						reAttr.addFlashAttribute("findOK", findStr);
						return "redirect:/main/findAdminID-result";
					}
					
				}
				
			}
			
			
		}
		
		
		return "redirect:/main/findAdminID-result";
		
	}
	
	@GetMapping("/findAdminID-result")
	public void adminIDResultGET()
	{
		logger.info("id result");
		
		
	}
	
	
	
	// 관리자 비밀번호 찾기
	@GetMapping("/findAdminPWD")
	public void findAdminPWDGET()
	{
		logger.info("비밀번호 찾기");
		
	}
	
	@PostMapping("/findAdminPWD")
	public String findAdminPWDPOST(Model model, 
					RedirectAttributes reAttr,
					@ModelAttribute("adminName") String name,
					@ModelAttribute("adminID") String id
					)
	{
		logger.info("find Password Post");
		
		List<AdminVO> pwdList = serviceAdmin.read();
		String findStr = "";
		for(AdminVO avo : pwdList)
		{
			if((avo.getAdminName().equals(name) == true) && 
					 (avo.getAdminID().equals(id) == true))
			{
				logger.info("비밀번호는 " + avo.getAdminPWD() + "입니다.");
				findStr = avo.getAdminPWD();
				reAttr.addFlashAttribute("findOK", findStr);
				return "redirect:/main/findAdminPWD-result";
			}
			
		}
		
		return "redirect:/main/findAdminPWD-result";
		
	}
	
	@GetMapping("/findAdminPWD-result")
	public void AdminPWDResultGET()
	{
		logger.info("비밀번호 찾기 결과");
		
	}
	
	
}
