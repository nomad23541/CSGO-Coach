package com.chrisreading.coach.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
	
	public AddGrenadeTrainingDialogController() {}

	@Override
	protected void initialize() {

	}

	@Override
	protected void handleOk() {

	}

	@Override
	protected void handleCancel() {

	}

}
