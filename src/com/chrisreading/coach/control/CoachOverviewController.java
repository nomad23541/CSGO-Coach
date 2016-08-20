package com.chrisreading.coach.control;

import com.chrisreading.coach.MainApp;
import com.chrisreading.coach.model.Task;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

/**
 * Controller class for the CoachOverview
 */
public class CoachOverviewController {
	
	/** Reference to the main class */
	private MainApp mainApp;
	
	/** FXML */
	@FXML
	private ListView<Task> taskList;
	@FXML
	private ListView<Task> taskDragDropList;
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
		mainApp.showCreateTaskDialog();
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
