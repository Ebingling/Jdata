package com.demo.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "usertable")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private String address;

}
