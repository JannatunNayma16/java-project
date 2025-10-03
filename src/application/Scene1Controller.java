package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene1Controller {
	
	
	@FXML
	private Button Back1button ;
	@FXML
	private AnchorPane scenepane ;
	@FXML
	private Button RulesButton ;
	
	@FXML
	private Button demobutton ;
	@FXML
	private Button lev31button ;
	@FXML
	private Button lev32button ;
	@FXML
	private Button lev33button ;
	
	@FXML
	private AnchorPane scenepane3 ;
	
	@FXML
	private Button Next1button ;
	Stage stage ;
	
	
	private Scene scene ;
	private Parent root ;
	
	

	
	
	public void Lev(ActionEvent event) throws IOException
	{
		 root = FXMLLoader.load(getClass().getResource("Scenelevel.fxml"));
		 stage =(Stage) ((Node)event.getSource()).getScene().getWindow() ;
		 scene = new Scene(root) ;
		 stage.setScene(scene);
		 stage.show();

	}	
	
	
	public void Rules(ActionEvent event) throws IOException
	{
		 root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		 stage =(Stage) ((Node)event.getSource()).getScene().getWindow() ;
		 scene = new Scene(root) ;
		 stage.setScene(scene);
		 stage.show();

	}
	
	public void logout(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION) ;
		alert.setTitle(" Exit");
		alert.setContentText("Do you want to Exit?") ;
				
		if(alert.showAndWait().get()==ButtonType.OK)
		{
			stage = (Stage) scenepane.getScene().getWindow() ;
			//System.out.println("You sucessfully logged out") ;
			stage.close() ;
		}
	}
	
}