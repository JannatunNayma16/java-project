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
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene2Controller {
	
	
	
	@FXML
	private Button  Easybutton;
	@FXML
	private Button  mediumbutton;
	@FXML
	private Button Hardbutton ;
	
	@FXML
	private Button Back2button ;
	@FXML
	private Button Back3button ;
	@FXML
	private AnchorPane scenepane2 ;
//	@FXML
//	private AnchorPane scenepane3 ;
	
	@FXML
	private Button Next2button ;
	Stage stage ;
	
	
	private Scene scene ;
	private Parent root ;
	
	
	
	
	public void Back2(ActionEvent event) throws IOException
	{
		 root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		 stage =(Stage) ((Node)event.getSource()).getScene().getWindow() ;
		 scene = new Scene(root) ;
		 stage.setScene(scene);
		 stage.show();
	}
	
	public void Eassy(ActionEvent event) throws IOException
	{
		 root = FXMLLoader.load(getClass().getResource("Scene31.fxml"));
		 stage =(Stage) ((Node)event.getSource()).getScene().getWindow() ;
		 scene = new Scene(root) ;
		 stage.setScene(scene);
		 stage.show();

	}
	
	public void Mmedium(ActionEvent event) throws IOException
	{
		 root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
		 stage =(Stage) ((Node)event.getSource()).getScene().getWindow() ;
		 scene = new Scene(root) ;
		 stage.setScene(scene);
		 stage.show();

	}
	
	public void Hhard(ActionEvent event) throws IOException
	{
		 root = FXMLLoader.load(getClass().getResource("Scene33.fxml"));
		 stage =(Stage) ((Node)event.getSource()).getScene().getWindow() ;
		 scene = new Scene(root) ;
		 stage.setScene(scene);
		 stage.show();

	}
	
}