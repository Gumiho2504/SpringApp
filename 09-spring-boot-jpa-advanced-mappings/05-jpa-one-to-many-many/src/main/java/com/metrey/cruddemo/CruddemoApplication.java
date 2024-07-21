package com.metrey.cruddemo;


import com.metrey.cruddemo.dao.AppDAO;
import com.metrey.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			//createCourseAndStudent(appDAO);
			//findCourseAndStudent(appDAO);
			findStudentAndCourse(appDAO);
			//updateStudent(appDAO);
			//deleteCourse(appDAO);
			//deleteStudent(appDAO);
		};
	}
	private void deleteStudent(AppDAO appDAO){
		int theId = 2;
		System.out.println("deleting student id = " + theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Deleted!");

	}

	private void updateStudent(AppDAO appDAO) {
		int student_id = 2;
		Student tempStudent = appDAO.findStudentByStudentId(student_id);
		Course course1 = new Course("game-development");
		Course course2= new Course("app-developer");
		System.out.println("Adding new course for a student ......");
		tempStudent.addCourse(course1);
		tempStudent.addCourse(course2);

		appDAO.updateStudent(tempStudent);
		System.out.println("Finish !");

		System.out.println("tempStudent -> " + tempStudent + "theCourse --> " + tempStudent.getCourses());

	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding Student with id --> " + theId);
		Student student = appDAO.findStudentByStudentId(theId);
		System.out.println("the Student --> " + student);
		System.out.println("Course --> " + student.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		int theId = 10;
		System.out.println("finding Course id = " + theId);
		Course theCourse = appDAO.findCourseAndStudentByCourseId(theId);
		List<Student> tempStudent = theCourse.getStudents();

		System.out.println("theCourse : " + theCourse);
		System.out.println("the student with " + theCourse.getTitle() + " are " + tempStudent);

	}

	private void createCourseAndStudent(AppDAO appDAO) {
		// create the course
		System.out.println("Creating the course .....");
		Course theCourse = new Course("Music");

		// create the student
		System.out.println("Creating students ....");
		Student student1 = new Student("Srey","Len","sreylen@gmail.com");
		Student student2 = new Student("Metrey","Fly","metrey@gmail.com");

		// add student to the course
		theCourse.addStudent(student1);
		theCourse.addStudent(student2);
		System.out.println("Saving .....");
		// save the course
		appDAO.saveCourse(theCourse);
		System.out.println("Saved!");
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id =  " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Deleted!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;

		System.out.println("finding course id = " + theId);
		Course temCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println("tempCourse --> " +temCourse);
		System.out.println("review -->"+temCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Water-Festival");

		// adds some reviews

		Review review1 = new Review("it's so happy");
		Review review2 = new Review("biggest festival in cambodia");
		Review review3 = new Review("Bad its too noise");
		tempCourse.addReviews(review1);
		tempCourse.addReviews(review2);
		tempCourse.addReviews(review3);

		System.out.println("Saving teh course");
		System.out.println("tempCourse : " + tempCourse);
		System.out.println("Review List " + tempCourse.getReviews());

		// save the course
		appDAO.saveCourse(tempCourse);
		System.out.println("Saved!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Delete course at id = " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Deleted!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("finding course by id = " + theId);
		Course tempCourse = appDAO.findCourseById(theId);
		System.out.println("updating course id = " + theId);
		tempCourse.setTitle("Hello welcome");
		appDAO.update(tempCourse);
		System.out.println("Updated!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		// find the instructor
		System.out.println("finding instructor id = " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update instructor
		System.out.println("Updating instructor id " + theId);
		tempInstructor.setLastName("Gumiho");
		appDAO.update(tempInstructor);
		System.out.println("Done");
	}

	private void findInstructorWithCourseJoinFetch(AppDAO appDAO) {
		int theId = 1;

		// find instructor
		System.out.println("finding instructor id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstuctor wiht Join Fetch : " + tempInstructor);
		System.out.println("the associate course : " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCourseForInstructor(AppDAO appDAO) {
		int theId = 1;

		// find instructor by id
		System.out.println("finding instructor at id = "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor = " + tempInstructor);




		// find course by instructor id

		System.out.println("find course by instructor id = " + theId);
		List<Course> tempCourse = appDAO.findCourseByInstructorId(theId);
		System.out.println("tempCourse" + tempCourse);
		// associate the object
		tempInstructor.setCourses(tempCourse);
		System.out.println("Course the instructor id =  " + theId + " ---> " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourse(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor = " + tempInstructor);
		System.out.println("the associate course : " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourse(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor(
				"Gumiho","345","gumiho@gmail.com"
		);

		InstructorDetail tempInstructorDetail = new InstructorDetail("https://Gumiho","Gumiho-LoGy");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some course
		Course tempCourse1 = new Course("Gumiho-Monster");
		Course tempCourse2 = new Course("Monster_Master");

		// add course to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save Instructor
		// NOTE : this will save the course
		// because of CascadeType.PERSIST

		System.out.println("Saving instructor :  " + tempInstructor);
		System.out.println("The Course : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor detail id : " + theId);
		appDAO.deleteInstuctorDetailById(theId);
		System.out.println("Deleted");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetail theInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("find instrutorDetail at id ---> " + theId);
		System.out.println("theInstuctorDetail = " + theInstructorDetail );
		System.out.println("the associate instructor = " + theInstructorDetail.getInstructor());
	}

	private void deleteInstuctor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deletd Instructor at id -> " + theId);
		appDAO.deleteInstructorById(1);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Find Instructor by id = " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Gu","Miho","hemchandsmetrey@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("https/yodfutube.com","gumsiho12");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// NOTE : this will also save the instructor detail object
		// because of CascadeType.ALL

		// save instructor
		appDAO.save(tempInstructor);

		System.out.printf("Done!");
	}

}
