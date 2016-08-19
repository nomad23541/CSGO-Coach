package com.chrisreading.coach.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Task model
 */
public class Task {

	/* Dummy data for testing model */
	private StringProperty title;
	private StringProperty date;
	private DateFormat dateFormat;
	private StringProperty detail1;
	private StringProperty detail2;
	
	/**
	 * Default constructor
	 */
	public Task() {
		this(null, null, null);
	}
	
	/**
	 * Constuctor with initial data
	 */
	public Task(String title, String detail1, String detail2) {
		this.title = new SimpleStringProperty(title);
		this.detail1 = new SimpleStringProperty(detail1);
		this.detail2 = new SimpleStringProperty(detail2);
		
		dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		this.date = new SimpleStringProperty(dateFormat.format(date));
	}
	
	/**
	 * GETTER & SETTERS
	 */
	
	public String getDate() {
		return date.get();
	}
	
	public String getTitle() {
		return title.get();
	}
	
	public void setTitle(String title) {
		this.title.set(title);
	}
}
