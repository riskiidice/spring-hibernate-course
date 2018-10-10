package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorDetailRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.repository.StudentRepository;

@Component
public class PlayGround implements CommandLineRunner{

	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private InstructorDetailRepository instructorDetailRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Running......");
		
		Instructor tempInstructor = new Instructor("Tikumporn", "Wankvar", "tikumporn.wan@pea.co.th");
		InstructorDetail tempInstructorDetail = new InstructorDetail("tkp-dev", "Luv2Code");
		Course tempCourse1 = new Course("JAVA Coding");
		tempCourse1.addReview(new Review("Good explantion....!"));
		tempCourse1.addReview(new Review("Good Preparation....!"));
		Course tempCourse2 = new Course("Python Coding");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		Student tempStudent = new Student("Tikumporn", "Wankvar", "tikumporn.wan@pea,co,th");
		Student tempStudent2 = new Student("Tikumporn2", "Wankvar2", "tikumporn.wan@pea,co,th");
		tempCourse1.addStudent(tempStudent);
		tempCourse1.addStudent(tempStudent2);
		
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		courseRepository.save(tempCourse1);
		courseRepository.save(tempCourse2);
		
		System.out.println("Course: "+ tempCourse1);
		System.out.println("Reviews: "+tempCourse1.getReviews());
		System.out.println("Saved Student: "+tempCourse1.getStudents());
		
//		try {
//			InstructorDetail tempDetail = instructorDetailRepository.findById(1).get();
//			System.out.println("Instructor: "+tempDetail.getInstructor());
//			
//			System.out.println("Instructor Courses: "+tempInstructor.getCourses());
//			
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
				
	}

}
