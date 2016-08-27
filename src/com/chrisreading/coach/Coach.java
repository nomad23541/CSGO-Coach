package com.chrisreading.coach;

import java.io.IOException;

import com.chrisreading.coach.control.AddDeathmatchDialogController;
import com.chrisreading.coach.control.CoachOverviewController;
import com.chrisreading.coach.model.DeathmatchTask;
import com.chrisreading.coach.model.Task;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Main class for coach
 */
public class Coach extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	/**
	 * List of created tasks
	 */
	private ObservableList<Task> taskData = FXCollections.observableArrayList();
	
	/**
	 * Get the main stage
	 * @return The primary stage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * Get the task data
	 * @return The list of tasks
	 */
	public ObservableList<Task> getTaskData() {
		return taskData;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Coach");
		
		initRootLayout();
		showCoachOverview();
	}	
	
	/**
	 * Load & show the root scene
	 */
	public void initRootLayout() {
		try {
			// load rootlayout from it's file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Coach.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// show the scene containing rootlayout
			Scene scene = new Scene(rootLayout);
			primaryStage.getIcons().add(new Image(Coach.class.getResourceAsStream("/res/icon.png")));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load & show the coach overview inside the root
	 */
	public void showCoachOverview() {
		try {
			// load overview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Coach.class.getResource("view/CoachOverview.fxml"));
			AnchorPane coachOverview = (AnchorPane) loader.load();
			
			// set coach overview to center of rootlayout
			rootLayout.setCenter(coachOverview);
			
			// give controller access to MainApp
			CoachOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load & show the task create dialog
	 */
	public void showCreateTaskDialog() {
		try {
			// load the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Coach.class.getResource("view/CreateTaskDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
					
			// create the dialog stage
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Create Task");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			// show the dialog and wait til the user closes it
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load & show the add deathmatch dialog
	 */
	public boolean showAddDeathmatchDialog(DeathmatchTask task) {
		try {
			// load the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Coach.class.getResource("view/AddDeathmatchDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
					
			// create the dialog stage
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Deathmatch");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			// set the controller
			AddDeathmatchDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDeathmatch(task);
			
			// show the dialog and wait til the user closes it
			dialogStage.showAndWait();
			
			return controller.isAddClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
