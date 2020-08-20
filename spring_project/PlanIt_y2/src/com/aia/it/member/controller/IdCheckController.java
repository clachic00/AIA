package com.aia.it.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aia.it.member.service.IdCheckService;

@Controller
public class IdCheckController {
	
	@Autowired
	private IdCheckService idCheckService;
	
	@RequestMapping("/member/idCheck")
	@ResponseBody // 메서드의 반환 데이터를 뷰의 데이터로 사용
	public String idCheck(
			@RequestParam("uid") String uid,
			Model model
			) {
		System.out.println(uid);
		return idCheckService.checkId(uid);	
		
	}
	
	@RequestMapping("/member/unameCheck")
	@ResponseBody // 메서드의 반환 데이터를 뷰의 데이터로 사용
	public String unameCheck(
			@RequestParam("uname") String uname,
			Model model
			) {
		System.out.println(uname);
		return idCheckService.checkName(uname);	
		
	}



}
