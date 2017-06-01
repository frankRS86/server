package main.java.security;

import java.util.Arrays;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import main.java.persistence.IUserPersistence;
import main.java.persistence.User;
import main.java.persistence.UserPersistence;

@Service
public class UserAuthorizationHandler implements UserDetailsService {
	
	Logger logger = Logger.getLogger("UserAuthorization");
	
	@Autowired
	private IUserPersistence iUserPersistence;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		logger.info("loadUserByUserNameis called for user "+username);
		
		User user = iUserPersistence.findOne(username);
		
		if (user == null) {
			
			logger.info("cannot find user 401 access denied "+username);
			
			throw new UsernameNotFoundException("Username " + username + " notfound");
		}
		
		logger.info("user found. setting role to "+username);
		
		//OTHER USER OBJECT!!!
		return new org.springframework.security.core.userdetails.User(username, "password", getGrantedAuthorities(username));
	}
	
	
	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
		Collection<? extends GrantedAuthority> authorities;
		
		if (username.equals("frank")) 
		{
			logger.info("adding ROLE_ADMIN and ROLE_BASIC to user "+username);
			authorities = Arrays.asList(() -> "ROLE_ADMIN", () -> "ROLE_BASIC");
		} 
		else if (username.equals("admin")) 
		{
			logger.info("adding ROLE_ADMIN and ROLE_BASIC to user "+username);
			authorities = Arrays.asList(() -> "ROLE_ADMIN", () -> "ROLE_BASIC");
		} 
		else 
		{
			logger.info("adding ROLE_BASIC to user "+username);
			authorities = Arrays.asList(() -> "ROLE_BASIC");
		}
		return authorities;
}
}