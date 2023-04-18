package com.sample.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Member {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	
}
