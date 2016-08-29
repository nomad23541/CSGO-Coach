package com.chrisreading.coach.handler;

import java.util.ArrayList;
import java.util.List;

import com.chrisreading.coach.model.Task;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Instead of manually
 * adding new labels in the code, 
 * this will take a list of labels and a list
 * of tasks and add them to a gridpane
 */
public class GridPaneNodeHandler {
	
	private GridPane pane; // to be manipulated
	
	public GridPaneNodeHandler(GridPane pane) {
		this.pane = pane;
	}
	
	// to be worked on more, instead of string arrays addable images and integers
	public void addNodes(String[] titles, String[] details) {
		List<Label> labelTitles = new ArrayList<Label>();
		List<Label> labelDetails = new ArrayList<Label>();
		
		for(String title : titles) {
			labelTitles.add(new Label(title + ":"));
		}
		
		for(String detail : details) {
			labelDetails.add(new Label(detail));
		}
		
		// set to 1 (title and date get the first row)
		for(int i = 1; i < labelTitles.size(); i++) {
			Label title = labelTitles.get(i);		
			pane.add(title, 0, i);
		}
		
		for(int i = 1; i < labelDetails.size(); i++) {
			Label detail = labelDetails.get(i);
			pane.add(detail, 1, i);
		}
	}

}
