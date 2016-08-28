package com.chrisreading.coach.control;

import java.io.File;

import com.chrisreading.coach.model.GrenadeTrainingTask;
import com.chrisreading.coach.util.CoachUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Controller class for the GrenadeTraining Dialog
 */
public class AddGrenadeTrainingDialogController extends DialogController {
	
	/**
	 * FXML
	 */
	@FXML
	private ComboBox<String> mapComboBox;
	@FXML
	private ComboBox<String> nadeComboBox;
	@FXML
	private TextField scoreATop;
	@FXML
	private TextField scoreABot;
	@FXML
	private TextField scoreBTop;
	@FXML
	private TextField scoreBBot;
	@FXML
	private Button attachButton;
	@FXML
	private TextField imageLocField;
	@FXML
	private ImageView imageView;
	
	public AddGrenadeTrainingDialogController() {}

	@Override
	protected void initialize() {
		task = new GrenadeTrainingTask();
		
		imageLocField.setEditable(false);
		
		// add all maps to combobox
		for(String map : CoachUtil.maps) {
			mapComboBox.getItems().add(map);
		}
		
		// add all grenades to combobox
		for(String nade : CoachUtil.grenades) {
			nadeComboBox.getItems().add(nade);
		}
	}
	
	/** 
	 * Open filechooser and find image
	 */
	@FXML
	private void handleAttach() {
		FileChooser fc = new FileChooser();
		FileChooser.ExtensionFilter filter = new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp");
		fc.setSelectedExtensionFilter(filter);
		fc.setTitle("Attach an image");
		File file = fc.showOpenDialog(dialogStage);
		
		if(file != null) {
			((GrenadeTrainingTask) task).setImage(new Image(file.toURI().toString(), true));
			imageView.setImage(((GrenadeTrainingTask) task).getImage());
			imageLocField.setText(file.getAbsolutePath());
		}
		
	}

	@Override
	protected void handleOk() {
		((GrenadeTrainingTask) task).setGrenade(nadeComboBox.getSelectionModel().getSelectedItem());
		((GrenadeTrainingTask) task).setMap(mapComboBox.getSelectionModel().getSelectedItem());
		((GrenadeTrainingTask) task).setScoreATop(Integer.parseInt(scoreATop.getText()));
		((GrenadeTrainingTask) task).setScoreBTop(Integer.parseInt(scoreBTop.getText()));
		((GrenadeTrainingTask) task).setScoreABot(Integer.parseInt(scoreABot.getText()));
		((GrenadeTrainingTask) task).setScoreBBot(Integer.parseInt(scoreBBot.getText()));
		
		dialogStage.close();
		okClicked = true;
	}

	@Override
	protected void handleCancel() {
		dialogStage.close();
	}

}
