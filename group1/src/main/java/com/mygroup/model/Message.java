package com.mygroup.model;

public class Message {

	  private String message;
	  private int id;
	  private String messageUser;;
	  
	  public Message() {
	    
	  }
	  
	  public Message(int id, String message) {
	    this.id = id;
	    this.message = message;
	  //  this.messageUser = messageUser;
	   // this.messageUser = messageUser;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	/*public String getMessageUser() {
		return messageUser;
	}

	public void setMessageUser(String messageUser) {
		this.messageUser = messageUser;
	}
	  
	  */
	  
	}
	
	  