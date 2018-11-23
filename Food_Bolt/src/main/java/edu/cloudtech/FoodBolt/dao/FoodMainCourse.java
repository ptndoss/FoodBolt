package edu.cloudtech.FoodBolt.dao;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;


@DynamoDBDocument
public class FoodMainCourse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String main_1;
	private String main_2;
	private String main_3;
	private String main_4;
	private String main_5;
	private String main_6;
	private String main_7;
	private String main_8;
	private String main_9;
	private String main_10;
	
	@DynamoDBAttribute
	public String getMain_1() {
		return main_1;
	}
	public void setMain_1(String main_1) {
		this.main_1 = main_1;
	}
	
	@DynamoDBAttribute
	public String getMain_2() {
		return main_2;
	}
	public void setMain_2(String main_2) {
		this.main_2 = main_2;
	}
	
	@DynamoDBAttribute
	public String getMain_3() {
		return main_3;
	}
	public void setMain_3(String main_3) {
		this.main_3 = main_3;
	}
	
	@DynamoDBAttribute
	public String getMain_4() {
		return main_4;
	}
	public void setMain_4(String main_4) {
		this.main_4 = main_4;
	}
	
	@DynamoDBAttribute
	public String getMain_5() {
		return main_5;
	}
	public void setMain_5(String main_5) {
		this.main_5 = main_5;
	}
	
	@DynamoDBAttribute
	public String getMain_6() {
		return main_6;
	}
	public void setMain_6(String main_6) {
		this.main_6 = main_6;
	}
	
	
	@DynamoDBAttribute
	public String getMain_7() {
		return main_7;
	}
	public void setMain_7(String main_7) {
		this.main_7 = main_7;
	}
	
	@DynamoDBAttribute
	public String getMain_8() {
		return main_8;
	}
	public void setMain_8(String main_8) {
		this.main_8 = main_8;
	}
	
	
	@DynamoDBAttribute
	public String getMain_9() {
		return main_9;
	}
	public void setMain_9(String main_9) {
		this.main_9 = main_9;
	}
	
	
	@DynamoDBAttribute
	public String getMain_10() {
		return main_10;
	}
	public void setMain_10(String main_10) {
		this.main_10 = main_10;
	}
	
	
	
	
	
}

