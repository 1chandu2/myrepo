package com.bizauth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bizauth.dao.UserDAO;
import com.bizauth.model.UserDTO;
import com.bizauth.model.UserVO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired UserDAO userDAO;
	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Value("${clientId}") 
	private String clientIdCheck;

	@Value("${secretKey}") 
	private String secretKeyCheck;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDAO.findByUsername(username);
		if (userVO == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(userVO.getUsername(), userVO.getPassword(),
				new ArrayList<>());
	}			
	public UserVO save(UserDTO user) {
		UserVO newUser = new UserVO();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return  userDAO.save(newUser);
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