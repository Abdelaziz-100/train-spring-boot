package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
	   	SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);
			createMulipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
		    //updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDelated = studentDAO.deleteall();
		System.out.println("Delated row count:" + numRowsDelated);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id:" + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id:" + studentId);
		Student myStudent = studentDAO.findById(studentId);


		// change first name to "Nour El houda"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Nour El houda");

		//update the student
		studentDAO.update(myStudent);

		// display the updated student
	    System.out.println("Student updated" + myStudent);
	}


	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> thestudents = studentDAO.findbyLastName("gge");

		// display list of students
		for (Student tempStudent : thestudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

 		// get a list of students
		List<Student> thestudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : thestudents ) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Adem", "Atitallah", "adem@gmail.com");
		// save the student
		System.out.println("Saving student object...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saving student. Generated id: " + theId);
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		//display student
		System.out.println("Found the student: " + myStudent);


	}

	private void createMulipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating new student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "paul@luv2code.com");
		Student tempStudent2 = new Student("Aziz", "ZZZ", "pzzz@luv2code.com");
		Student tempStudent3 = new Student("Talha", "gge", "ggg@luv2code.com");

		// save the students objects
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the save student
		System.out.println("Saved student Generated id: " + tempStudent.getId());
	}
}
