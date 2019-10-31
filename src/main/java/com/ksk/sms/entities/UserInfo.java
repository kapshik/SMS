package com.ksk.sms.entities;

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
@Table(name="t_user")
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="id")
	private String id;
	
	@Column(name="user")
	private String user;
	
	@Column(name="password")
	private String password;
}

