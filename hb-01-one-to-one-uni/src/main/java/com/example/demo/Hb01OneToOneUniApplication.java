package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.repository.InstructorDetailRepository;
import com.example.demo.repository.InstructorRepository;

@SpringBootApplication
public class Hb01OneToOneUniApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(Hb01OneToOneUniApplication.class, args);
	}
	
}
