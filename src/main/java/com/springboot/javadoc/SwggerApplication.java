package com.springboot.javadoc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.javadoc")
public class SwggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwggerApplication.class, args);
	}
}
