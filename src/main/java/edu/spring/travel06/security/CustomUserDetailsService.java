package edu.spring.travel06.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.spring.travel06.domain.AdminVO;
import edu.spring.travel06.domain.UserVO;
import edu.spring.travel06.security.domain.CustomUser;
import edu.spring.travel06.service.AdminService;
import edu.spring.travel06.service.UserService;


@Service
public class CustomUserDetailsService implements UserDetailsService
{
	private static final Logger logger = 
			LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private AdminService serviceAdmin;
	

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		logger.info("Load User by UserName : " + username);
		UserVO uvo; AdminVO avo;
		CustomUser custom = new CustomUser();
		
		boolean isUser = checkUser(username);
		boolean isAdmin = checkAdmin(username);
		logger.info("사용자인가?" + isUser + ", 관리자인가?:" + isAdmin );
		if(isUser)
		{
			uvo = serviceUser.read(username);
			custom = new CustomUser(uvo);
			
			custom.setUsername(uvo.getUserID());
			custom.setPassword(uvo.getUserPWD());
			ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	        auth.add(new SimpleGrantedAuthority("ROLE_USER"));
			custom.setAuthorities(auth);
		}
		
		if(isAdmin)
		{
			avo = serviceAdmin.read(username);
			custom = new CustomUser(avo);
			
			
			custom.setUsername(avo.getAdminID());
			custom.setPassword(avo.getAdminPWD());
			
			ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	        auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			custom.setAuthorities(auth);
		}
		
		if(isAdmin == false && isUser == false)
		{
			custom = new CustomUser();
		}
		
        return custom; // 여기서 return된 UserDetails는 SecurityContext의 Authentication에 등록되어 인증 정보를 갖고 있는다.
		
		
	}
	
	
	
	public boolean checkUser(String name) 
	{
		logger.info("id check : " + name);
		UserVO uvo = serviceUser.read(name);
		
		if(uvo == null)
		{
			return false;
		}
			
		else
		{
			return name.equals(uvo.getUserID());
		}
		
		
	}
	
	public boolean checkAdmin(String name) 
	{
		logger.info("id check : " + name);
		AdminVO avo = serviceAdmin.read(name);
		if(avo == null)
		{
			return false;
		}
		else
		{
			return name.equals(avo.getAdminID());
		}
		
		
		
	}
	
	
	
}
