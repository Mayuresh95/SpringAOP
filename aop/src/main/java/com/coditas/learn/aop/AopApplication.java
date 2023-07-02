package com.coditas.learn.aop;

import com.coditas.learn.aop.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EntityScan
public class AopApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext app = SpringApplication.run(AopApplication.class, args);
		Student student = app.getBean(Student.class);
		student.setName("Mayuresh Chaudhari");
		System.out.println(student.submitAssignment(2));
	}
}

