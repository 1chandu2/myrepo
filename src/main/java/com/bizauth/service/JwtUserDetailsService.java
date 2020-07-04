package com.bizauth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Value("${clientId}") 
	private String clientIdCheck;

	@Value("${secretKey}") 
	private String secretKeyCheck;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("bizhives".equals(username)) {
			return new User("bizhives", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}			
	
	public void checkConfig(String clientId,String secretKey) throws Exception {
		
		
		if(clientId.equals(clientIdCheck) && secretKey.equals(secretKeyCheck))
		{
			
		}
		else {
			throw new Exception("" + clientId);
		}
		
	
	}

}