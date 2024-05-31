package com.example.securityEx01.dto;

import lombok.Data;

@Data
public class Member {

	private int mno;
	private String username;
	private String password;
	private String nickname;
	private String role;
}
