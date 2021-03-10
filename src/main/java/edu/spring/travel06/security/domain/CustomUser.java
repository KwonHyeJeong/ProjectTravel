package edu.spring.travel06.security.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import edu.spring.travel06.controller.CommonController;
import edu.spring.travel06.domain.*;


public class CustomUser implements UserDetails
{
	private Collection<? extends GrantedAuthority> authorities;
    private String username;  // principal - biz name : email
    private String password;  // credential


    
    private UserVO uvo;

	private AdminVO avo;
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // ROLE
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    // -------------- 계정에 대한 디테일한 설정 -----------------
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {return true;
                                             }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // -----------------------------------------------

 

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public UserVO getUvo() {
		return uvo;
	}

	public void setUvo(UserVO uvo) {
		this.uvo = uvo;
	}

	public AdminVO getAvo() {
		return avo;
	}

	public void setAvo(AdminVO avo) {
		this.avo = avo;
	}

	@Override
	public String toString() {
		return "CustomUser [authorities=" + authorities + ", username=" + username + ", password=" + password
				+ ", uvo=" + uvo + ", avo=" + avo + "]";
	}
    
	public CustomUser() {};
	
	
    public CustomUser(Collection<? extends GrantedAuthority> authorities, String username, String password,
			UserVO uvo, AdminVO avo) 
    {
		super();
		this.authorities = authorities;
		this.username = username;
		this.password = password;
		
		this.uvo = uvo;
		this.avo = avo;
	}
    
    
    
	public CustomUser(UserVO vo)
    {
		
		this.uvo = vo;
    	
    }
	
	public CustomUser(AdminVO vo)
	{
		this.avo = vo;
		
	}

	
	
	
	
	
	
}
