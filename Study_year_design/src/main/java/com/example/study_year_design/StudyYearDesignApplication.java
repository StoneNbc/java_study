package com.example.study_year_design;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.example.study_year_design.mapper")
public class StudyYearDesignApplication {


	public static void main(String[] args) {
		SpringApplication.run(StudyYearDesignApplication.class, args);
	}

}
