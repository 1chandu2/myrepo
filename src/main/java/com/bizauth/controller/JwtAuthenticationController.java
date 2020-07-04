package com.bizauth.controller;

import java.util.Objects;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
/*import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
*/import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.bizauth.config.JwtTokenUtil;
import com.bizauth.model.JwtRequest;
import com.bizauth.model.JwtResponse;
import com.bizauth.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest,HttpServletRequest request) throws Exception {
		
		try {
			
			final String clientId = request.getHeader("clientId");
			final String secretKey = request.getHeader("secretKey");
			userDetailsService.checkConfig(clientId,secretKey);
			
		}
		catch(Exception ex)
		{
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, "Incorrect clientId or secretKey :"+ex.getMessage(),ex);
			
		}
		//System.out.print("log:"+authenticationRequest.getClientId());

		try {
	authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		}
		catch(Exception ex2) {
			
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, "Incorrect username or password  :"+ex2.getMessage(),ex2);
			
		}
		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
