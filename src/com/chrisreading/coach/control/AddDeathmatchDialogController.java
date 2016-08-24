package com.chrisreading.coach.control;

import com.chrisreading.coach.MainApp;
import com.chrisreading.coach.model.DeathmatchTask;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the CoachOverview
 */
public class AddDeathmatchDialogController {
	
	/** Reference to the main class */
	private MainApp mainApp;
	
	/** Task being added */
	private DeathmatchTask task;
	
	/** Stage for this dialog */
	private Stage dialogStage;
	
	private boolean addClicked = false;
	
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
	@FXML
	private Button addButton;
	@FXML
	private Button cancelButton;
	
	/**
	 * Constructor
	 */
	public AddDeathmatchDialogController() {
		
	}
	
	/**
	 * Called before the constructor
	 */
	@FXML
	private void initialize() {

	}
	
	/**
	 * Called on press of add button
	 */
	@FXML
	private void handleAdd() {
		task.setKills(Integer.parseInt(killsField.getText()));
		task.setAssists(Integer.parseInt(assistsField.getText()));
		task.setDeaths(Integer.parseInt(deathsField.getText()));
		task.setGun(gunField.getText());
		task.setTime(timeField.getText());
		
		addClicked = true;
		dialogStage.close();
	}
	
	/**
	 * Called on press of cancel button
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	/**
	 * Sets the main app, make it accessible for this class
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setDeathmatch(DeathmatchTask task) {
		this.task = task;
	}
	
	public void setDialogStage(Stage stage) {
		this.dialogStage = stage;
	}
	
	public boolean isAddClicked() {
		return addClicked;
	}

}