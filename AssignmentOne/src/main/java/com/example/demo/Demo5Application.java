package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.model.InsufficientBalance;
import com.model.MyService;
import com.model.TransactionService;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})
public class Demo5Application {

	public static void main(String[] args) throws InsufficientBalance {
		ApplicationContext applicationContext=SpringApplication.run(Demo5Application.class, args);
		
//		MyService myservice=applicationContext.getBean("myService",MyService.class);
//		myservice.doService(100,200);
//		
//		MyService myservice1=applicationContext.getBean("myService",MyService.class);
//		myservice.doService(100,60000);
		
		
		TransactionService transactionService = applicationContext.getBean("transactionService",TransactionService.class);
		transactionService.moneyTransfer(100, 200, 1000);
////		System.out.println(DTO);
	}

}
