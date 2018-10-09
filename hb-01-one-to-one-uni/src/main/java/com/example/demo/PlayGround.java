package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.repository.InstructorRepository;

@Component
public class PlayGround implements CommandLineRunner{

	@Autowired
	private InstructorRepository instructorRepository;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Running......");
		
		Instructor tempInstructor = new Instructor("Tikumporn", "Wankvar", "tikumporn.wan@pea.co.th");
		InstructorDetail tempInstructorDetail = new InstructorDetail("tkp-dev", "Luv2Code");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		System.out.println("Instructor: "+tempInstructor);
		instructorRepository.save(tempInstructor);
		
		tempInstructor = instructorRepository.findById(1).get();
		
		if(tempInstructor != null) {
			instructorRepository.delete(tempInstructor);
		}
		
	}

}
