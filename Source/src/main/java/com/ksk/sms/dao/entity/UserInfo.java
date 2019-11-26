package com.ksk.sms.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tbl_user")
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="role")
	private String role;
}

