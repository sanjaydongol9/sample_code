package com.cubic.ipm.util;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class AuthenticatedUser extends org.springframework.security.core.userdetails.User{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6217856132581046709L;
	private Long userId;
	private String userEmail; 

  
    public AuthenticatedUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AuthenticatedUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    

}
