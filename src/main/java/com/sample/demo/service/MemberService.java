package com.sample.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.demo.dao.MemberRepository;
import com.sample.demo.entity.Member;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	public void postMember(Member member) {
		memberRepository.save(member);
	}

	@Transactional
	public boolean login(Member member) {
		Member result = memberRepository.findMemberByName(member.getName());
		if (result == null) {
			return false;
		}
		if (!result.getPassword().equals(member.getPassword())) {
			return false;
		}
		return true;
	}

}
