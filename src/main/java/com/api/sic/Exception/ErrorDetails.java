package com.api.sic.Exception;

import java.util.Date;

public class ErrorDetails {

	private Date Heur;
	private String message;
	private String Details;
	
	
	public ErrorDetails(Date Heur, String message, String details) {
		super();
		this.Heur = Heur;
		this.message = message;
		this.Details = details;
	}
	public Date getHeur() {
		return Heur;
	}
	public void setHeur(Date Heur) {
		this.Heur = Heur;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}


}
