package com.sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.demo.entity.Member;
import com.sample.demo.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("success")
	public String success() {
		return "success";
	}

	@RequestMapping("join")
	public String join() {
		return "join";
	}

	@PostMapping("join")
	public void postMember(@RequestBody Member member) {
		memberService.postMember(member);
	}

	@RequestMapping("home")
	public String home() {
		return "home";
	}

	@PostMapping("home")
	public String login(Member member) {
		if (memberService.login(member)) {
			return "success";
		}
		return "redirect:home";
	}

}
