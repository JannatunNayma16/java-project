package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController2 implements Initializable {
	
	
	
    @FXML
    private GridPane grid;
    @FXML
	private AnchorPane scenepanelev3 ; 
    @FXML
	private AnchorPane scenepanelev31 ; 
    @FXML
	private AnchorPane scenepanelev33; 
    @FXML
	private AnchorPane whitepane ;
    @FXML
	private AnchorPane Blackpane ;
    @FXML
    private Button back31button;
    @FXML
    private Button back32button;
    @FXML
    private Button Back1button;
    @FXML
    private Button bbackbutton;
    Stage stage ;
	
	
	private Scene scene ;
	private Parent root ;

    Character l = null, current = null;
    int currCol = -1;
    boolean[][] gridboard;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gridboard = new boolean[grid.getRowCount() - 1][grid.getColumnCount()];
        startGrid();
    }
    public void Backfromlev(ActionEvent event) throws IOException{
    	 root = FXMLLoader.load(getClass().getResource("Scenelevel.fxml"));
		 stage =(Stage) ((Node)event.getSource()).getScene().getWindow() ;
		 scene = new Scene(root) ;
		 stage.setScene(scene);
		 stage.show();
    }
    private void check(int col, int row, char c) {
        if(col == currCol) {
            if (c == 'W' && !gridboard[row - 1][col - 1])
                for(int i = 0; i < row; i++) gridboard[i][col - 1] = true;
            else if(c == 'B' && !gridboard[row - 1][col - 1])
                for(int i = grid.getRowCount() - 2; i >= row; i--) gridboard[i][col - 1] = true;
        }
        else if(currCol == -1) {
            if (c == 'W')
                for(int i = 0; i < row; i++) gridboard[i][col - 1] = true;
            else if(c == 'B')
                for(int i = grid.getRowCount() - 2; i >= row; i--) gridboard[i][col - 1] = true;
        }
    }
    private boolean check(int col) {
        for(int i = 0; i < grid.getRowCount() - 1; i++) {
            if(!gridboard[i][col - 1]) return true;
        }
        return false;
    }

    private  boolean checkWin() {
        for (int i = 0; i < grid.getRowCount() - 1; i++)
            for (int j = 0; j < grid.getColumnCount() - 1; j++)
                if(!gridboard[i][j]) return false;
        return true;
    }

    private void startGrid() {

        grid.getChildren().forEach(item -> {
            if(item instanceof Label tmp) {
                if(Objects.equals(tmp.getText(), "W") || Objects.equals(tmp.getText(), "B")){
                    gridboard[GridPane.getRowIndex(item) - 1][GridPane.getColumnIndex(item) - 1] = true;
                    if(GridPane.getRowIndex(item) != grid.getRowCount() - 1) check(GridPane.getColumnIndex(item), GridPane.getRowIndex(item), tmp.getText().charAt(0));
                }
            }

            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Label tmp = (Label) item;

                    if(l == null) {
                        if(check(GridPane.getColumnIndex(item))) {
                            if(current == null || current != tmp.getText().charAt(0)) {
                                current = l = tmp.getText().charAt(0);
                                tmp.setText(null);
                                currCol = GridPane.getColumnIndex(item);
                            }
                        }
                    }

                    else {
                        if(!gridboard[GridPane.getRowIndex(item) - 1][GridPane.getColumnIndex(item) - 1]) {
                            check(GridPane.getColumnIndex(item), GridPane.getRowIndex(item), l);
                            tmp.setText(String.valueOf(l));
                            l = null;
                            gridboard[GridPane.getRowIndex(item) - 1][GridPane.getColumnIndex(item) - 1] = true;
                            if (checkWin()) {
                                if (current == 'W') 
                                {
                                	//System.out.println("White Wins");
                                	
                                	try {
                            			Parent root = FXMLLoader.load(getClass().getResource("Whitewin.fxml"));
                            			Stage primaryStage = (Stage)back31button.getScene().getWindow();
                            			Scene scene = new Scene(root);
                            			primaryStage.setScene(scene);
                            			primaryStage.show();
                            		
                            		} catch(Exception e) {
                            			e.printStackTrace();
                            		}
                                                           	
                                }
                                else if (current == 'B') 
                                {
                                	//System.out.println("Black Wins");
                                	
                                	try {
                            			Parent root = FXMLLoader.load(getClass().getResource("Blackwin.fxml"));
                            			Stage primaryStage = (Stage)back31button.getScene().getWindow();
                            			Scene scene = new Scene(root);
                            			primaryStage.setScene(scene);
                            			primaryStage.show();
                            		
                            		} catch(Exception e) {
                            			e.printStackTrace();
                            		}
                                }
                            }
                        }
                    }

                    for (int i = 0; i < grid.getRowCount() - 1; i++) {
                        for (int j = 0; j < grid.getColumnCount() - 1; j++)
                            System.out.print(gridboard[i][j] + " ");
                        System.out.println();
                    }
                    System.out.println();
                }
            });
        });
    }
}