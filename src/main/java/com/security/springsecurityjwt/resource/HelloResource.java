package com.security.springsecurityjwt.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.springsecurityjwt.Model.AuthenticationRequest;
import com.security.springsecurityjwt.Util.JWTUtil;
import com.security.springsecurityjwt.security.MyUserDetailsService;

@RestController
public class HelloResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtil util;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	@GetMapping("/hello")
	public String hello(){
		return "Hello World";
	}
	
	@RequestMapping(value ="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception{
		
		try{
		 authenticationManager.authenticate(
				 new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
				 );
		}
		catch(BadCredentialsException e){
			throw new Exception("Username / passsword incorrect");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		
		final String jwt = util
				
				
	}
}
