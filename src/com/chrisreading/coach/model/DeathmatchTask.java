package com.chrisreading.coach.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Deathmatch model task
 */
public class DeathmatchTask extends Task {
	
	private IntegerProperty deaths, kills, assists;
	private StringProperty time, gun;
	
	/**
	 * Default Constructor
	 */
	public DeathmatchTask() {
		this(0, 0, 0, null, null);
	}
	
	/**
	 * Customizable constructor
	 * @param deaths
	 * @param kills
	 */
	public DeathmatchTask(int deaths, int kills, int assists, String gun, String time) {
		this.setTitle("Deathmatch"); // set title as this is a default task
		
		this.deaths = new SimpleIntegerProperty(deaths);
		this.kills = new SimpleIntegerProperty(kills);
		this.assists = new SimpleIntegerProperty(assists);
		this.time = new SimpleStringProperty(time);
		this.gun = new SimpleStringProperty(gun);
	}
	
	/**
	 * GETTER SETTERS
	 */
	
	public void setGun(String gun) {
		this.gun.set(gun);
	}
	
	public String getGun() {
		return this.gun.get();
	}
	
	public void setTime(String time) {
		this.time.set(time);
	}
	
	public String getTime() {
		return time.get();
	}
	
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
