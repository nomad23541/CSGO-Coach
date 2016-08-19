package com.chrisreading.coach;

import java.io.IOException;

import com.chrisreading.coach.view.CoachOverviewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class for coach
 */
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	/**
	 * Get the main stage
	 * @return The primary stage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
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
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// show the scene containing rootlayout
			Scene scene = new Scene(rootLayout);
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
			loader.setLocation(MainApp.class.getResource("view/CoachOverview.fxml"));
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
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
