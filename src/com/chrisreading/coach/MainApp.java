package com.chrisreading.coach;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
