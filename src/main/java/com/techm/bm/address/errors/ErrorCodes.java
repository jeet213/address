package com.techm.bm.address.errors;

public enum ErrorCodes {
	
	  DATABASE_CONNECTION_FAILED(0, "A database connection is lost...."),
	  SERVER_ERROR (1, "An internal Error occurred");

	  private final int code;
	  private final String description;

	  private ErrorCodes(int code, String description) {
	    this.code = code;
	    this.description = description;
	  }

	  public String getDescription() {
	     return description;
	  }

	  public int getCode() {
	     return code;
	  }

	  @Override
	  public String toString() {
	    return code + ": " + description;
	  }
	}
