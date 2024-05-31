package com.example.securityEx01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.securityEx01.dto.Member;
import com.example.securityEx01.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyContoller {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping("/index")
	public String root() {
		log.info("root.........");
		
		return "index";
	}
	
	@RequestMapping("/regForm")
	public String regForm() {
		log.info("regForm..........");
		
		return "regForm";
	}
	
	@RequestMapping("/regProc")
	public String regProc(Member member) {
		log.info("regProc........" + member);
		
		String newPw = bCryptPasswordEncoder.encode(member.getPassword());
		member.setPassword(newPw);
		member.setRole("ROLE_USER");
		
		memberMapper.regMember(member);
		
		return "redirect:/";
	}
	                 
	@RequestMapping("/members/membersPage")
	public String memberPage() {
		log.info("members Page..................");
		
		return "members/membersPage";
	}
	
	@RequestMapping("/admin/adminPage")
	public String adminPage() {
		log.info("admin Page..................");
		
		return "admin/adminPage";
	}
	
	@RequestMapping("/guest")
	public String guest() {
		log.info("guest........");
		return "guestPage";
	}
	
	@RequestMapping("/login")
	public String login() {
		log.info("login.............");
		return "login";
	}
	
	@RequestMapping("/fail")
	public String fail() {
		log.info("fail..........");
		return "fail";
	}
}
