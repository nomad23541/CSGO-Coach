package com.chrisreading.coach.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Abstract task model for all tasks
 */
public abstract class Task {

	/* Dummy data for testing model */
	protected StringProperty title;
	protected StringProperty date;
	
	/**
	 * Default constructor
	 */
	public Task() {
		this(null);
	}
	
	/**
	 * Constructor with initial data
	 */
	public Task(String title) {
		this.title = new SimpleStringProperty(title);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
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
