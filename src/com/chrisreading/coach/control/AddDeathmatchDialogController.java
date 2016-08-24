package com.chrisreading.coach.control;

import com.chrisreading.coach.MainApp;
import com.chrisreading.coach.model.DeathmatchTask;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller class for the CoachOverview
 */
public class AddDeathmatchDialogController {
	
	/** Reference to the main class */
	private MainApp mainApp;
	
	/** Task being added */
	private DeathmatchTask task;
	
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
	public AddDeathmatchDialogController(DeathmatchTask task) {
		this.task = task;
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

	}
	
	/**
	 * Called on press of cancel button
	 */
	@FXML
	private void handleCancel() {

	}
	
	/**
	 * Sets the main app, make it accessible for this class
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}

