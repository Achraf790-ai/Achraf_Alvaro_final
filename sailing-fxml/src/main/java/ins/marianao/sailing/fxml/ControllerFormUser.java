package ins.marianao.sailing.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import cat.institutmarianao.sailing.ws.model.User;
import ins.marianao.sailing.fxml.manager.ResourceManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ControllerFormUser implements Initializable {
	@FXML private BorderPane viewLoginForm;
	
	
	@FXML private TextField txtUsername;
	@FXML private PasswordField txtPassword;
	@FXML private PasswordField txtConfirm;
	@FXML private PasswordField txtName;
	@FXML private PasswordField txtPhone;
	@FXML private Button btnRegister;
	
	@FXML private ComboBox<String> comboBox;
	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		comboBox.setItems(FXCollections.observableArrayList("Admin","User"));
	}

	/**
	 * Called when btnLogin button is fired.
	 *
	 * @param event the action event.
	 */
	@FXML
	public void loginClick(ActionEvent event) {

		ResourceManager.getInstance().getMenuController().login(this.txtUsername.getText(),
																this.txtPassword.getText());
	}

	public void loadUserProfile(User user) {
		// TODO Auto-generated method stub
		
	}
	
	
}
