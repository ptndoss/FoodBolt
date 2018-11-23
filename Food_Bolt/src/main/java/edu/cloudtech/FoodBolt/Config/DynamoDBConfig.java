package edu.cloudtech.FoodBolt.Config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

import edu.cloudtech.FoodBolt.dao.FoodListRepository;

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = FoodListRepository.class)
public class DynamoDBConfig {

	
//	 @Value("${amazon.dynamodb.endpoint}")
//	 private String amazonDynamoDBEndpoint;
	   
	@Value("${amazon.aws.accesskey}")
	private String awsAccessKey;
 
	@Value("${amazon.aws.secretkey}")
	private String awsSecretKey;
 
	
//	 @Bean
//	 public AmazonDynamoDB amazonDynamoDB() {
//	        AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
//	          
//	        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
//	            dynamoDB.setEndpoint(amazonDynamoDBEndpoint);
//	        }
//	          
//	        return dynamoDB;
//	    }
//	 
	 
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB(AWSCredentials awsCredentials) {
		@SuppressWarnings("deprecation")
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials);
		return amazonDynamoDB;
	}
 
	public AWSCredentialsProvider amazonAWSCredentialsProvider() {
		return new AWSStaticCredentialsProvider(amazonAWSCredentials());
	}
	
	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
	}
	
	@Bean
	public DynamoDBMapperConfig dynamoDBMapperConfig() {
		return DynamoDBMapperConfig.DEFAULT;
	}

	@Bean
	public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
		return new DynamoDBMapper(amazonDynamoDB, config);
	}

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
				.withRegion(Regions.US_EAST_1).build();
	}
	
	
}
