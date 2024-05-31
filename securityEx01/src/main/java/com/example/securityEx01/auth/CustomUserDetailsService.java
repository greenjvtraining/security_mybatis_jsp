package com.example.securityEx01.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securityEx01.dto.Member;
import com.example.securityEx01.mapper.MemberMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member userData = memberMapper.findByUsername(username);
		System.out.println("userData : " + userData);
		if(userData != null) {
			return new CustomUserDetails(userData);
		}
		return null;
	}

}
