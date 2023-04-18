package com.sample.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sample.demo.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {

//	Member findByNameAndPassword(String name, String password);

	@Query(value = "select * from member where name = ?", nativeQuery = true)
	Member findMemberByName(String name);

//	@Query(value = "select * from user where name  = ? AND password = ?", nativeQuery = true)
//	Member login(String name, String password);
}
