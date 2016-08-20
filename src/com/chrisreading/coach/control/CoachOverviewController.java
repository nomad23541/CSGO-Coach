package com.chrisreading.coach.control;

import com.chrisreading.coach.MainApp;
import com.chrisreading.coach.model.DeathmatchTask;
import com.chrisreading.coach.model.Task;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * Controller class for the CoachOverview
 */
public class CoachOverviewController {
	
	/** Reference to the main class */
	private MainApp mainApp;
	
	/** FXML */
	@FXML
	private ListView<Task> taskListDone;
	@FXML
	private ListView<Task> taskList;
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
		// temporary for testing
		DeathmatchTask dt = new DeathmatchTask(4, 15);
		DeathmatchTask dt2 = new DeathmatchTask(4, 23);
		taskList.getItems().add(dt);
		taskList.getItems().add(dt2);
		
		/**
		 * Store tasks in the listviews but only show the
		 * variable "title" as the label
		 */
		taskList.setCellFactory(param -> new ListCell<Task>() {
			@Override
			protected void updateItem(Task item, boolean empty) {
				super.updateItem(item, empty);
				
				if(empty || item == null || item.getTitle() == null) {
					setText(null);
				} else {
					setText(item.getTitle());
				}
			}
		});
		
		taskListDone.setCellFactory(param -> new ListCell<Task>() {
			@Override
			protected void updateItem(Task item, boolean empty) {
				super.updateItem(item, empty);
				
				if(empty || item == null || item.getTitle() == null) {
					setText(null);
				} else {
					setText(item.getTitle());
				}
			}
		});
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
	
	/**
	 * When the task list is double clicked, 
	 * bring the selected task to the task list done
	 * listview
	 */
	public void onTaskListClicked(MouseEvent event) {	
		// if 2 clicks
		if(event.getClickCount() == 2) {
			Task task = taskList.getSelectionModel().getSelectedItem();
			// now add that task to the done list
			taskListDone.getItems().add(task);
		}
	}

}
