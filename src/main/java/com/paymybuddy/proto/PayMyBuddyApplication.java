package com.paymybuddy.proto;

import com.paymybuddy.proto.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayMyBuddyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PayMyBuddyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}
}
