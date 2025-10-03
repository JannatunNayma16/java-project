package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			
			
			
			Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
			
			
			stage.setOnCloseRequest(event -> {
				event.consume();
				logout(stage);
				});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void logout(Stage stage)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION) ;
		alert.setTitle("Exit");
		alert.setContentText("Do you want to Exit?") ;
				
		if(alert.showAndWait().get()==ButtonType.OK)
		{
			System.out.println("You sucessfully logged out") ;
			stage.close() ;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}