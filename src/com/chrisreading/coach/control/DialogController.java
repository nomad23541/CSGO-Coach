package com.chrisreading.coach.control;

import com.chrisreading.coach.Coach;
import com.chrisreading.coach.model.Task;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Use for all dialog controllers
 * @author Chris
 *
 */
public abstract class DialogController {
	
	/** Reference to the main class */
	protected Coach coach;
	
	/** Task being added */
	protected Task task;
	
	/** Stage for this dialog */
	protected Stage dialogStage;
	
	protected boolean okClicked = false;
	
	/** FXML */
	@FXML
	protected Button okButton;
	@FXML
	protected Button cancelButton;
	
	/**
	 * Called before constructor
	 */
	@FXML
	protected abstract void initialize();

	@FXML
	protected abstract void handleOk();
	
	@FXML
	protected abstract void handleCancel();
	
	/**
	 * Makes the main class accessible here
	 * @param coach Main class
	 */
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	/**
	 * Sets what kind of task this dialog will be manipulating
	 * @param task
	 */
	public void setTask(Task task) {
		this.task = task;
	}
	
	public void setDialogStage(Stage stage) {
		this.dialogStage = stage;
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
}
