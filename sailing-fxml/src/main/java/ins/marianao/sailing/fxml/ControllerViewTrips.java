package ins.marianao.sailing.fxml;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import cat.institutmarianao.sailing.ws.model.Client;
import cat.institutmarianao.sailing.ws.model.Trip;
import ins.marianao.sailing.fxml.manager.ResourceManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableCell;

public class ControllerViewTrips extends Application {
	
	

	
	//comboboxes y fechas.
	@FXML private ComboBox<String> cmbClient; 
	@FXML private ComboBox<String> cmbCategory;
	@FXML private ComboBox<String> cmbAll;
	@FXML private DatePicker frontDate;
	@FXML private DatePicker toDate;
	
	@FXML private PasswordField txtPassword;
	@FXML private Button btnLogin;
	
	//declaro para llamar a clientes 
	String clients = Client.CLIENT; 

	//tabla;
	@FXML private TableView<Trip> viajesTable;
	
	@FXML private TableColumn<Trip, Number> colIndex;
	@FXML private TableColumn<Trip, String> colClient;
	@FXML private TableColumn<Trip, String> colCategory;
	@FXML private TableColumn<Trip, String> colTitle;
	@FXML private TableColumn<Trip, Number> colMax;
	@FXML private TableColumn<Trip, Number> colBooked;
	@FXML private TableColumn<Trip, String> colStatus;
	@FXML private TableColumn<Trip, String> colDate;
	@FXML private TableColumn<Trip, String> colDeparture;
	@FXML private TableColumn<Trip, Number> colPlaces;
	@FXML private TableColumn<Trip, String> colComments;
	
	@FXML private TableColumn<Trip, Void> colCancel;
	@FXML private TableColumn<Trip, Void> colReschedulingTrip;
	@FXML private TableColumn<Trip, Void> colDone;
	
	public void initialize(URL url, ResourceBundle resource) {
		
		cmbClient.setItems(FXCollections.observableArrayList("Client"));    //CORREGIR(no sé como llamarlo desde ld db)
		cmbCategory.setItems(FXCollections.observableArrayList("Private","Group"));
		cmbAll.setItems(FXCollections.observableArrayList("All","RESERVED","RESCHEDULED", "CANCELLED", "DONE"));
		

		colDone.setCellFactory(column -> new TableCell<Trip, Void>() {
	        private final ImageView imageView = new ImageView();

	        @Override
	        protected void updateItem(Void item, boolean empty) {
	            super.updateItem(item, empty);
	            if (empty) {
	                setGraphic(null); 
	            } else {
	     
	                Image image = new Image(getClass().getResourceAsStream("/resources/done.png"));
	                imageView.setImage(image);
	                setGraphic(imageView); 
	            }
	        }
	    });
		

		colCancel.setCellFactory(column -> new TableCell<Trip, Void>() {
	        private final ImageView imageView = new ImageView();

	        @Override
	        protected void updateItem(Void item, boolean empty) {
	            super.updateItem(item, empty);
	            if (empty) {
	                setGraphic(null); 
	            } else {
	              
	                Image image = new Image(getClass().getResourceAsStream("/resources/cancel.png"));
	                imageView.setImage(image);
	                setGraphic(imageView); 
	            }
	        }
	    });
		

		colReschedulingTrip.setCellFactory(column -> new TableCell<Trip, Void>() {
	        private final ImageView imageView = new ImageView();

	        @Override
	        protected void updateItem(Void item, boolean empty) {
	            super.updateItem(item, empty);
	            if (empty) {
	                setGraphic(null); 
	            } else {
	       
	                Image image = new Image(getClass().getResourceAsStream("/resources/reschedule.png"));
	                imageView.setImage(image);
	                setGraphic(imageView); 
	            }
	        }
	    });
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			ResourceManager.getInstance().setStage(primaryStage);
			ResourceManager.getInstance().setApp(this);

			Locale.setDefault(new Locale("CA","ES"));
			ResourceBundle applicationBundle = ResourceBundle.getBundle("application");
			ResourceManager.getInstance().setApplicationBundle(applicationBundle);
			ResourceBundle translationsBundle = ResourceBundle.getBundle("i18n/messages");
			ResourceManager.getInstance().setTranslationBundle(translationsBundle);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAppSailingGUI.fxml"), translationsBundle);
			VBox root = (VBox) loader.load();

			ResourceManager.getInstance().setMenuController(loader.getController());
			
			Scene scene = new Scene(root, 1100, 700);
			scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Catamaran");
			scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Dosis");
			scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Special+Elite");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle(ResourceManager.getInstance().getText("fxml.text.app.title"));
			primaryStage.setMinWidth(1100);
			primaryStage.setMaxWidth(1600);
			primaryStage.setMinHeight(700);
			primaryStage.setMaxHeight(960);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch();
	}
}
