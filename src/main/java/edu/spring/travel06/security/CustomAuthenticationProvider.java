package edu.spring.travel06.security;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import edu.spring.travel06.domain.*;

import edu.spring.travel06.security.domain.CustomUser;
import edu.spring.travel06.service.AdminService;
import edu.spring.travel06.service.UserService;
import edu.spring.travel06.persistance.*;



public class CustomAuthenticationProvider implements AuthenticationProvider
{
	private static final Logger logger = 
			LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private CustomUserDetailsService cuds;
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private AdminService serviceAdmin;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException 
	{
		String id = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		
		
		CustomUser custom = new CustomUser();
		logger.info("authentication id : " + id);
		logger.info("authentication pwd : " + password);
		
//		logger.info(cuds.loadUserByUsername(id).toString());
		
		custom = (CustomUser) cuds.loadUserByUsername(id);
		
		logger.info(custom.toString());
		
		
		
		
		
		
		
		
		if(!matchPassword(password, custom.getPassword())) {
            throw new BadCredentialsException(id);
        }
 
        if(!custom.isEnabled()) {
            throw new BadCredentialsException(id);
        }
        
        return new UsernamePasswordAuthenticationToken(id, password, custom.getAuthorities());


		
	}

	@Override
	public boolean supports(Class<?> authentication) 
	{
		// TODO Auto-generated method stub
		return true;
	}
	
	 private boolean matchPassword(String loginPwd, String password) 
	 {
	        return loginPwd.equals(password);
	 }


	
	
}
