package com.metrey.aopdemo;

import com.metrey.aopdemo.dao.AccountDAO;
import com.metrey.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO){
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account tempAccount = new Account("Hello","2");
		// call the business method
		theAccountDAO.addAccount(tempAccount,true);
		theAccountDAO.doWork();

		// call the membership business method
		theMembershipDAO.addSilyMember();
		theMembershipDAO.goToSleep();


	}

}

