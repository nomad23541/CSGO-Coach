package com.chrisreading.coach.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class GrenadeTrainingTask extends Task {
	
	private IntegerProperty scoreATop, scoreABot, scoreBTop, scoreBBot;
	private StringProperty map, nade;
	private Image image;
	
	/**
	 * Default Constructor
	 */
	public GrenadeTrainingTask() {
		this(null, null, 0, 0, 0, 0);
	}
	
	public GrenadeTrainingTask(String map, String nade, int scoreATop, int scoreABot, int scoreBTop, int scoreBBot) {
		this.setTitle("Grenade Training"); // set title as this is a default task
		
		this.scoreATop = new SimpleIntegerProperty(scoreATop);
		this.scoreABot = new SimpleIntegerProperty(scoreABot);
		this.scoreBTop = new SimpleIntegerProperty(scoreBTop);
		this.scoreBBot = new SimpleIntegerProperty(scoreBBot);
		this.map = new SimpleStringProperty(map);
		this.nade = new SimpleStringProperty(nade);
	}
	
	/**
	 * GETTER SETTERS
	 */
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	
	public String getMap() {
		return map.get();
	}
	
	public void setMap(String map) {
		this.map.set(map);
	}
	
	public String getGrenade() {
		return nade.get();
	}
	
	public void setGrenade(String nade) {
		this.nade.set(nade);
	}
	
	public int getScoreATop() {
		return scoreATop.get();
	}
	
	public int getScoreABot() {
		return scoreABot.get();
	}
	
	public int getScoreBTop() {
		return scoreBTop.get();
	}
	
	public int getScoreBBot() {
		return scoreBBot.get();
	}
	
	public void setScoreATop(int score) {
		this.scoreATop.set(score);
	}
	
	public void setScoreABot(int score) {
		this.scoreABot.set(score);
	}
	
	public void setScoreBTop(int score) {
		this.scoreBTop.set(score);
	}
	
	public void setScoreBBot(int score) {
		this.scoreBBot.set(score);
	}

}
