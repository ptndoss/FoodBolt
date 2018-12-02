package edu.cloudtech.FoodBolt.chatbot;

public class DialogAction {
	
	private String type;
	private String fullfillmentState;
	private Message message;
	
	public DialogAction(String type, String fullfillmentState, Message message) {
		super();
		this.type = type;
		this.fullfillmentState = fullfillmentState;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFullfillmentState() {
		return fullfillmentState;
	}

	public void setFullfillmentState(String fullfillmentState) {
		this.fullfillmentState = fullfillmentState;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	
	

}
