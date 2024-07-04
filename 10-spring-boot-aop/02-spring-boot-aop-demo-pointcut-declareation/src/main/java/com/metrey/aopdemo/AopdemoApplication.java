package com.metrey.aopdemo;

import com.metrey.aopdemo.dao.AccountDAO;
import com.metrey.aopdemo.dao.MembershipDAO;
import com.metrey.aopdemo.service.TrafficFortunrService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortunrService trafficFortunrService){
		return runner -> {
			//demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			// demoAfterThrowingAdvice(theAccountDAO);
			//demoAfterAdvice(theAccountDAO);
			demoTheAroundAdvice(trafficFortunrService);

		};
	}

	private void demoTheAroundAdvice(TrafficFortunrService trafficFortunrService) {
		System.out.println("\n main program : demoTheAroundAdvice");
		System.out.println("Calling getFortune....?");
		String data = trafficFortunrService.getFortune();
		System.out.println("my fortune is : " + data);
		System.out.println("Finished");
	}

	private void demoAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccount = null;
		try{
			boolean tripWire = true;
			theAccount = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exp){
			System.out.println("\n\n main program : ... caught exception : " + exp);
		}

		// display account
		System.out.println("\n\n main Program : demoTheAfterThrowingAdvice");
		System.out.println("-----------------");
		System.out.println(theAccount);
	}

	private void demoAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccount = null;
		try{
			boolean tripWire = true;
			theAccount = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exp){
			System.out.println("\n\n main program : ... caught exception : " + exp);
		}

		// display account
		System.out.println("\n\n main Program : demoTheAfterThrowingAdvice");
		System.out.println("-----------------");
		System.out.println(theAccount);
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccount = theAccountDAO.findAccounts();

		// display the account
		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice");
		System.out.println("-------");

		System.out.println(theAccount);

		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account tempAccount = new Account("Hello","2");
		// call the business method
		theAccountDAO.addAccount(tempAccount,true);
		theAccountDAO.doWork();


		// call the accountdao setter/getter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("golds");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSilyMember();
		theMembershipDAO.goToSleep();


	}

}

