package com.chrisreading.coach.view;

import com.chrisreading.coach.MainApp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

/**
 * Controller class for the CoachOverview
 */
public class CoachOverviewController {
	
	/** Reference to the main class */
	private MainApp mainApp;
	
	/** FXML */
	@FXML
	private ScrollPane taskListPane;
	@FXML
	private ScrollPane taskDetailsPane;
	@FXML
	private ScrollPane taskCreationPane;
	@FXML
	private Button createButton;
	@FXML
	private Button removeButton;
	
	/**
	 * Constructor
	 */
	public CoachOverviewController() {
		
	}
	
	/**
	 * Called before the constructor
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Called on press of create button
	 */
	@FXML
	private void handleCreate() {
		System.out.println("create called");
	}
	
	/**
	 * Called on press of remove button
	 */
	@FXML
	private void handleRemove() {
		System.out.println("remove called");
	}
	
	/**
	 * Sets the main app, make it accessible for this class
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
