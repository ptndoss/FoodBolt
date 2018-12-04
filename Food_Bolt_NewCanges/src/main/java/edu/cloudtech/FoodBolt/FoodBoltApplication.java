package edu.cloudtech.FoodBolt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.cloudtech.FoodBolt.chatbot.FoodboltLambda;

@SpringBootApplication
public class FoodBoltApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodBoltApplication.class, args);
		new FoodboltLambda();
	}
}
