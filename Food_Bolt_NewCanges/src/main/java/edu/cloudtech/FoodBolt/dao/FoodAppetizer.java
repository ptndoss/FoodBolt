package edu.cloudtech.FoodBolt.dao;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class FoodAppetizer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String apt_1;
	private String apt_2;
	private String apt_3;
	private String apt_4;
	private String apt_5;
	private String apt_6;
	private String apt_7;
	private String apt_8;
	private String apt_9;
	private String apt_10;
	
	
	@DynamoDBAttribute
	public String getApt_1() {
		return apt_1;
	}
	public void setApt_1(String apt_1) {
		this.apt_1 = apt_1;
	}
	@DynamoDBAttribute
	public String getApt_2() {
		return apt_2;
	}
	public void setApt_2(String apt_2) {
		this.apt_2 = apt_2;
	}
	
	
	@DynamoDBAttribute
	public String getApt_3() {
		return apt_3;
	}
	public void setApt_3(String apt_3) {
		this.apt_3 = apt_3;
	}
	
	@DynamoDBAttribute
	public String getApt_4() {
		return apt_4;
	}
	public void setApt_4(String apt_4) {
		this.apt_4 = apt_4;
	}
	
	@DynamoDBAttribute
	public String getApt_5() {
		return apt_5;
	}
	public void setApt_5(String apt_5) {
		this.apt_5 = apt_5;
	}
	
	@DynamoDBAttribute
	public String getApt_6() {
		return apt_6;
	}
	public void setApt_6(String apt_6) {
		this.apt_6 = apt_6;
	}
	
	@DynamoDBAttribute
	public String getApt_7() {
		return apt_7;
	}
	public void setApt_7(String apt_7) {
		this.apt_7 = apt_7;
	}
	
	@DynamoDBAttribute
	public String getApt_8() {
		return apt_8;
	}
	public void setApt_8(String apt_8) {
		this.apt_8 = apt_8;
	}
	
	@DynamoDBAttribute
	public String getApt_9() {
		return apt_9;
	}
	public void setApt_9(String apt_9) {
		this.apt_9 = apt_9;
	}
	
	@DynamoDBAttribute
	public String getApt_10() {
		return apt_10;
	}
	public void setApt_10(String apt_10) {
		this.apt_10 = apt_10;
	}
	

}
