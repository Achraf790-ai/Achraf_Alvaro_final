package ins.marianao.sailing.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import cat.institutmarianao.sailing.ws.model.User;
import ins.marianao.sailing.fxml.exception.OnFailedEventHandler;
import ins.marianao.sailing.fxml.manager.ResourceManager;
import ins.marianao.sailing.fxml.services.ServiceSaveUser;
import javafx.collections.FXCollections;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	@FXML private TextField txtName;
	@FXML private TextField txtPhone;
	@FXML private Button btnRegister;
	
	@FXML private ComboBox<String> comboBox;
	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		
		// si es admin se ve el combobox, si es cliente no se puede ver.
		comboBox.setItems(FXCollections.observableArrayList("Admin","User"));
	}
	
	// TODO esto para cuando le demos click al boton de registrase	
	@FXML
	public void registerClick(ActionEvent event) {
		
		 String username = txtUsername.getText().trim();
	        String password = txtPassword.getText();
	        String confirm = txtConfirm.getText();
	        String name = txtName.getText().trim();
	        String phone = txtPhone.getText().trim();
	        String role = comboBox.getValue();

	        
	        if (username.isEmpty() || password.isEmpty() || confirm.isEmpty() ||
	            name.isEmpty() || phone.isEmpty() || role == null) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error de validación");
	            alert.setHeaderText(null);
	            alert.setContentText("Por favor, completa todos los campos.");
	            alert.showAndWait();
	            return;
	        }

	        if (!password.equals(confirm)) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error de validación");
	            alert.setHeaderText(null);
	            alert.setContentText("Las contraseñas no coinciden.");
	            alert.showAndWait();
	            return;
	        }
	           
	}
	
	private void addUsuari(User user) throws Exception{
		final ServiceSaveUser saveUser = new ServiceSaveUser(user, null, null, null, false);
		saveUser.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			
			@Override
			public void handle(WorkerStateEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		saveUser.setOnFailed(new OnFailedEventHandler(ResourceManager.getInstance().getText("error.formUser.save.web.service")));
		
		saveUser.start();
	}

	// esto no es importnante para lo que queremos hacer actualmente
    public void loadUserProfile(User user) {
        if (user != null) {
        	txtUsername.setText(user.getUsername());
        }
    }
	
	
}
