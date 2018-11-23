package edu.cloudtech.FoodBolt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.util.ImmutableMapParameter;




@Repository
public class FoodListRepository {

	@Autowired 
	private DynamoDBMapper mapper;
	
	public void addFoodList(FoodList foodList) {
		System.out.println(foodList.getRestaurant_id());
		System.out.println(foodList.getCategory());
		System.out.println("OutPut......." + foodList);
		mapper.save(foodList);
	}
	
	public FoodList getFoodList(int restaurant_id) {
		return mapper.load(FoodList.class, restaurant_id);
		
	}
	
	public void  deleteFoodList(FoodList foodList) {
		mapper.delete(foodList);
		
	}
	
	public void  updateFoodList(FoodList foodList) {
		
		try {
			System.out.println("In Update Food List Controller");
		    mapper.save(foodList, dynamoSaveExpression(foodList));
		} catch (ConditionalCheckFailedException e) {
		    //Handle conditional check
			
			e.getMessage();
		}
		
	}
	
	public DynamoDBSaveExpression dynamoSaveExpression(FoodList foodList) {
		DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expected = new HashMap<>();
		expected.put("RESTAURANT_ID", 
				new ExpectedAttributeValue(new AttributeValue(foodList.getRestaurant_id()))
				.withComparisonOperator(ComparisonOperator.EQ));
		saveExpression.setExpected(expected);
		
		
		return saveExpression;
		
		
	}
	
		
}
