package com.example.securityEx01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.securityEx01.dto.Member;

@Mapper
public interface MemberMapper {
	
	public void regMember(@Param("member") Member member);

	@Transactional
	public Member findByUsername(@Param("username") String username);
	
}
