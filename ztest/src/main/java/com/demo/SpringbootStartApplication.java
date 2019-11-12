package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.demo.mapper")
public class SpringbootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStartApplication.class, args);
	}

}

