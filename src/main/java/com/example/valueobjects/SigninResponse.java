package com.example.valueobjects;

public class SigninResponse {
	int returnCode;
	String returnMessage;
	/**
	 * @return the returnCode
	 */
	public int getReturnCode() {
		return returnCode;
	}
	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	/**
	 * @return the returnMessage
	 */
	public String getReturnMessage() {
		return returnMessage;
	}
	/**
	 * @param returnMessage the returnMessage to set
	 */
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

}
