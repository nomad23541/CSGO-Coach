package com.chrisreading.coach.control;

import com.chrisreading.coach.model.DeathmatchTask;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller class for the Deathmatch Dialog
 */
public class AddDeathmatchDialogController extends DialogController {
	
	/** FXML */
	@FXML
	private TextField gunField;
	@FXML
	private TextField timeField;
	@FXML
	private TextField killsField;
	@FXML
	private TextField deathsField;
	@FXML
	private TextField assistsField;

	public AddDeathmatchDialogController() {}

	@FXML
	protected void initialize() {
		task = new DeathmatchTask();
	}
	
	/**
	 * Called on press of add button
	 */
	@FXML
	protected void handleOk() {
		((DeathmatchTask) task).setKills(Integer.parseInt(killsField.getText()));
		((DeathmatchTask) task).setAssists(Integer.parseInt(assistsField.getText()));
		((DeathmatchTask) task).setDeaths(Integer.parseInt(deathsField.getText()));
		((DeathmatchTask) task).setGun(gunField.getText());
		((DeathmatchTask) task).setTime(timeField.getText());
		
		okClicked = true;
		dialogStage.close();
	}
	
	/**
	 * Called on press of cancel button
	 */
	@FXML
	protected void handleCancel() {
		dialogStage.close();
	}
}