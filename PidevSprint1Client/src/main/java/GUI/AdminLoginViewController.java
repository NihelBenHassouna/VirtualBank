package GUI;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class AdminLoginViewController {
	@FXML
	private TextField loginTextField;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Button loginButton;
	@FXML
	private Button resetButton;

	// Event Listener on Button[#resetButton].onAction
	@FXML
	public void ResetAction(ActionEvent event) {
		loginTextField.clear();
		passwordTextField.clear();
	}
}
