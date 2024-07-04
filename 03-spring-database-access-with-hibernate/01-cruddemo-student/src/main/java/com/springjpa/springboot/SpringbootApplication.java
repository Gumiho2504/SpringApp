package com.springjpa.springboot;

import com.springjpa.springboot.dao.StudentDAO;
import com.springjpa.springboot.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return  runner -> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			
			//queryForStudent(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			
			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students ...");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println(" Delete row count : " + numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id  : " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on th id : primary key

		int studentId = 1;
		System.out.println("Getting student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Smos"

		System.out.println("Update student ...");
		myStudent.setFirstName("Smos");



		// update the student
		studentDAO.update(myStudent);
		// display the update student
		System.out.println("Update student : " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a List of students
		List<Student> theStudent = studentDAO.findByLastName("Yi");

		// display list of students

		for (Student tempStudent: theStudent
			 ) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.findAll();
		for (Student tempStudent : theStudent
			 ) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object

		System.out.println("Create new student object ....");
		Student tempStudent = new Student("Chang","Yi","mdsfeeb@gmail.com");

		// save the student

		System.out.println("Saving the student .....");
		studentDAO.save(tempStudent);

		// display id of the save student

		 int theId = tempStudent.getId();
		System.out.println("Save student. Generate Id: " + theId);

		// retrieve student base on the id : primary key

		System.out.println("Retrieving student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student

		System.out.println("Found the student : " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// Create multiple student object
		System.out.println("Created new 3 students.....");
		Student student1 = new Student("Youen" ,"Sokthorn","youensokthorn@gmail.com");
		Student student2 = new Student("Panch","Chansok","panchchansok@gmail.com");
		Student student3 = new Student("Hem","Chanmetrey","hemchanmetrey123@gmail.com");
		// Save the 3 student
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Created new student object....");
		Student tempStudent = new Student("Gumiho","Evil","hemchanmetrey@gmail.com");
		// save the student object
		System.out.println("Save the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Save student . Generated id : " + tempStudent.getId());
	}




}// end of class
