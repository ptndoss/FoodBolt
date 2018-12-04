package edu.cloudtech.FoodBolt.chatbot;


import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class FoodboltLambda implements RequestHandler<Map<String, Object>, Object>{

	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {
		// TODO Auto-generated method stub
		Message msg = new Message("PlainText", "Reservation has been confirmed");
		DialogAction dialogAction = new DialogAction("Close", "Fullfilled", msg);
		
		
		return new LexRespond(dialogAction); 
		
	}

	
}
