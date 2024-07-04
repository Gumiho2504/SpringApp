package com.metrey.cruddemo;


import com.metrey.cruddemo.dao.AppDAO;
import com.metrey.cruddemo.entity.Instructor;
import com.metrey.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstuctor(appDAO);
		};
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
		Instructor tempInstructor = new Instructor("hem","chaGutrye","hemchandsmetrey@gmail.com");

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
