package com.chrisreading.coach.control;

import com.chrisreading.coach.model.DeathmatchTask;
import com.chrisreading.coach.util.CoachUtil;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Controller class for the Deathmatch Dialog
 */
public class AddDeathmatchDialogController extends DialogController {
	
	/** FXML */
	@FXML
	private ComboBox<String> gunComboBox;
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
		
		// add guns to the combobox
		for(String gun : CoachUtil.heavy) {
			gunComboBox.getItems().add(gun);
		}
		for(String gun : CoachUtil.pistols) {
			gunComboBox.getItems().add(gun);
		}
		for(String gun : CoachUtil.rifles) {
			gunComboBox.getItems().add(gun);
		}
		for(String gun : CoachUtil.smgs) {
			gunComboBox.getItems().add(gun);
		}
	}
	
	/**
	 * Called on press of add button
	 */
	@FXML
	protected void handleOk() {
		((DeathmatchTask) task).setKills(Integer.parseInt(killsField.getText()));
		((DeathmatchTask) task).setAssists(Integer.parseInt(assistsField.getText()));
		((DeathmatchTask) task).setDeaths(Integer.parseInt(deathsField.getText()));
		((DeathmatchTask) task).setGun(gunComboBox.getSelectionModel().getSelectedItem());
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