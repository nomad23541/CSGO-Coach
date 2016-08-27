package com.chrisreading.coach.control;

import com.chrisreading.coach.Coach;
import com.chrisreading.coach.model.DeathmatchTask;
import com.chrisreading.coach.model.Task;
import com.chrisreading.coach.util.MathUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Controller class for the CoachOverview
 */
public class CoachOverviewController {
	
	/** Reference to the main class */
	private Coach mainApp;
	
	/** FXML */
	@FXML
	private GridPane gridPane;
	@FXML
	private ListView<Task> taskListDone;
	@FXML
	private ListView<Task> taskList;
	@FXML
	private Button createButton;
	@FXML
	private Button removeButton;
	@FXML
	private Label detailTitle;
	@FXML
	private Label detailDate;
	
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
		DeathmatchTask dt = new DeathmatchTask();
		taskList.getItems().add(dt);
		
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
					setText(item.getTitle() + " - " + item.getDate());
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
	public void setMainApp(Coach mainApp) {
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
			
			boolean addClicked = false;
			if(task instanceof DeathmatchTask) {
				addClicked = mainApp.showAddDeathmatchDialog((DeathmatchTask) task);
			}
			
			// now add that task to the done list
			if(addClicked)
				taskListDone.getItems().add(task);
		}
	}
	
	/**
	 * Edit/Show details of task in grid pane
	 */
	public void onTaskListDoneClicked() {
		Task task = taskListDone.getSelectionModel().getSelectedItem();
		detailTitle.setText(task.getTitle());
		detailDate.setText(task.getDate());
		
		/** temporary detection */
		if(task instanceof DeathmatchTask) {
			Label assistsLabel = new Label("Assists");
			Label killsLabel = new Label("Kills");
			Label deathsLabel = new Label("Deaths");
			Label gunLabel = new Label("Gun");
			Label timeLabel = new Label("Time");
			Label kpmLabel = new Label("KPM");
			Label kdRatioLabel = new Label("K/D");
			
			Label detailTime = new Label(((DeathmatchTask) task).getTime());
			Label detailGun = new Label(((DeathmatchTask) task).getGun());
			Label detailAssists = new Label(Integer.toString(((DeathmatchTask) task).getAssists()));
			Label detailKills = new Label(Integer.toString(((DeathmatchTask) task).getKills()));
			Label detailDeaths = new Label(Integer.toString(((DeathmatchTask) task).getDeaths()));
			Label detailKD = new Label(Double.toString(
					MathUtil.calculateKD(((DeathmatchTask) task).getKills(), ((DeathmatchTask) task).getDeaths(), ((DeathmatchTask) task).getAssists())));
			Label detailKPM = new Label(Double.toString(MathUtil.calculateKPM(Integer.parseInt(((DeathmatchTask) task).getTime()), ((DeathmatchTask) task).getKills())));
			
			System.out.println(Double.toString(MathUtil.calculateKPM(Integer.parseInt(((DeathmatchTask) task).getTime()), ((DeathmatchTask) task).getKills())));

			// add rows to the pane with this specific task
			gridPane.add(gunLabel, 0, 2);
			gridPane.add(detailGun, 1, 2);
			gridPane.add(killsLabel, 0, 3);
			gridPane.add(detailKills, 1, 3);
			gridPane.add(deathsLabel, 0, 4);
			gridPane.add(detailDeaths, 1, 4);
			gridPane.add(assistsLabel, 0, 5);
			gridPane.add(detailAssists, 1, 5);
			gridPane.add(kdRatioLabel, 0, 6);
			gridPane.add(detailKD, 1, 6);
			gridPane.add(timeLabel, 0, 7);
			gridPane.add(detailTime, 1, 7);
			gridPane.add(kpmLabel, 0, 8);
			gridPane.add(detailKPM, 1, 8);
		}
	}

}
