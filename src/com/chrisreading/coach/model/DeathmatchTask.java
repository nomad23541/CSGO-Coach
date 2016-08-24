package com.chrisreading.coach.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Deathmatch model task
 */
public class DeathmatchTask extends Task {
	
	private IntegerProperty deaths, kills, assists;
	
	/**
	 * Default Constructor
	 */
	public DeathmatchTask() {
		this(0, 0, 0);
	}
	
	/**
	 * Customizable constructor
	 * @param deaths
	 * @param kills
	 */
	public DeathmatchTask(int deaths, int kills, int assists) {
		this.setTitle("Deathmatch"); // set title as this is a default task
		
		this.deaths = new SimpleIntegerProperty(deaths);
		this.kills = new SimpleIntegerProperty(kills);
		this.assists = new SimpleIntegerProperty(assists);
	}
	
	/**
	 * GETTER SETTERS
	 */
	
	public void setAssists(int assists) {
		this.assists.set(assists);
	}
	
	public int getAssists() {
		return assists.get();
	}
	
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
