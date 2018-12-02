package edu.cloudtech.FoodBolt;

import edu.cloudtech.FoodBolt.Config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class FoodBoltApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodBoltApplication.class, args);
		new FoodboltLambda();
	}
}
