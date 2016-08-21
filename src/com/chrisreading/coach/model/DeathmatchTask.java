package com.chrisreading.coach.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Deathmatch model task
 */
public class DeathmatchTask extends Task {
	
	private IntegerProperty deaths, kills;
	
	/**
	 * Default Constructor
	 */
	public DeathmatchTask() {
		this(0, 0);
	}
	
	/**
	 * Customizable constructor
	 * @param deaths
	 * @param kills
	 */
	public DeathmatchTask(int deaths, int kills) {
		this.setTitle("Deathmatch"); // set title as this is a default task
		
		this.deaths = new SimpleIntegerProperty(deaths);
		this.kills = new SimpleIntegerProperty(kills);
	}
	
	/**
	 * GETTER SETTERS
	 */
	
	public void setDeaths(int deaths) {
		this.deaths.set(deaths);
	}
	
	public int getDeaths() {
		return deaths.get();
	}
	
	public void setKills(int kills) {
		this.kills.set(kills);
	}
	
	public int getKills() {
		return kills.get();
	}

}
