package edu.cloudtech.FoodBolt.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class FoodDessert {
	
	private String des_1;
	private String des_2;
	private String des_3;
	private String des_4;
	private String des_5;
	private String des_6;
	private String des_7;
	private String des_8;
	private String des_9;
	private String des_10;
	
	
	
	@DynamoDBAttribute
	public String getDes_1() {
		return des_1;
	}
	public void setDes_1(String des_1) {
		this.des_1 = des_1;
	}
	
	@DynamoDBAttribute
	public String getDes_2() {
		return des_2;
	}
	public void setDes_2(String des_2) {
		this.des_2 = des_2;
	}
	
	@DynamoDBAttribute
	public String getDes_3() {
		return des_3;
	}
	public void setDes_3(String des_3) {
		this.des_3 = des_3;
	}
	
	@DynamoDBAttribute
	public String getDes_4() {
		return des_4;
	}
	public void setDes_4(String des_4) {
		this.des_4 = des_4;
	}
	
	@DynamoDBAttribute
	public String getDes_5() {
		return des_5;
	}
	public void setDes_5(String des_5) {
		this.des_5 = des_5;
	}
	
	@DynamoDBAttribute
	public String getDes_6() {
		return des_6;
	}
	public void setDes_6(String des_6) {
		this.des_6 = des_6;
	}
	
	@DynamoDBAttribute
	public String getDes_7() {
		return des_7;
	}
	public void setDes_7(String des_7) {
		this.des_7 = des_7;
	}
	
	@DynamoDBAttribute
	public String getDes_8() {
		return des_8;
	}
	public void setDes_8(String des_8) {
		this.des_8 = des_8;
	}
	
	@DynamoDBAttribute
	public String getDes_9() {
		return des_9;
	}
	public void setDes_9(String des_9) {
		this.des_9 = des_9;
	}
	
	@DynamoDBAttribute
	public String getDes_10() {
		return des_10;
	}
	public void setDes_10(String des_10) {
		this.des_10 = des_10;
	}
	

}
