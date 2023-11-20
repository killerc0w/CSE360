package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.*;
import javafx.stage.*;


public class Main extends Application {
	
	private TextField estimationField;
	private Label resultLabel;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Planning Poker");
			
			
	        // create planning poker estimation elements
	        Label taskLabel = new Label("Task:");
	        TextField taskField = new TextField();

	        Label estimationLabel = new Label("Estimation:");
	        estimationField = new TextField();

	        Button estimateButton = new Button("Estimate");
	        resultLabel = new Label();
	        
	        //create players list 
	        Label players = new Label("Players: ");
	        ListView<String> names = new ListView<>();
	        names.setPrefSize(100,300);
	        
	        //set names in list (names)
	        TextField enterName = new TextField();
	        HBox aContainer = new HBox();
	        Button add = new Button("Add");
	        ObservableList<String> items = FXCollections.observableArrayList();
	        	//items need to make names work^ 
	        add.setOnAction(event ->{
	        
	        	String newItem = enterName.getText();
	        	
	        	if (!newItem.isEmpty()) {
	                names.getItems().add(newItem);
	                enterName.clear();
	            }
	        	
	        });
	        
	        aContainer.getChildren().addAll(new Label("Enter Name: "), enterName, add);
	        
	        names.setItems(items);
	        
	        //Set up Vbox on right side for steps of planning poker
	        
	        VBox steps = new VBox();
	        
	        steps.setStyle("-fx-border-color: BLACK;");
	        
	        	//step 1 - searchable logs
	        
	        HBox step1 = new HBox();
	        Label searchLogs = new Label("Search Logs: ");
	        Button goToSearch = new Button("Press Me!");
	        step1.getChildren().addAll(searchLogs, goToSearch);
	        steps.getChildren().add(step1);
	        GridPane searchWindowP = new GridPane();
        	
        	Scene searchWindowW = new Scene(searchWindowP, 600, 600);
        	
        	Stage search = new Stage();
        	
        	search.setTitle("Search Logs");
        	search.setScene(searchWindowW);
	        
	        goToSearch.setOnAction(event ->{
	       
	        	
	        	search.show();
	        });
	        
	        		//search function for step 1
	        HBox searchBox = new HBox();
	        TextField searchField = new TextField();
	        Button searchBtn = new Button("Search");
	        ListView<String> searchDrop = new ListView<>();
	        ObservableList<String> searchItems = FXCollections.observableArrayList();
	        ObservableList<String> searchedItems = FXCollections.observableArrayList();
	        
	        searchBtn.setOnAction(event ->{
	        	
	        	searchDrop.getItems().clear();
	         
	        	
	        });
	       
	        Label title1 = new Label("Search: ");
	        searchBox.getChildren().addAll(title1,searchField,searchBtn);
	        searchWindowP.getChildren().addAll(searchBox,searchDrop );
	        
	        searchField.setPrefSize(300, 10);
	        searchDrop.setPrefSize(500, 300 );
	        
	        GridPane.setConstraints(searchBox, 50,50);
	        GridPane.setConstraints(searchDrop, 50, 80);
	        
	        
	        
	        
	        
	        // Set up layout
	        GridPane grid = new GridPane();					
	        grid.setPadding(new Insets(10, 10, 10, 10));
	        grid.setVgap(5);
	        grid.setHgap(5);
	        GridPane.setConstraints(steps, 100, 0);
	        GridPane.setConstraints(aContainer, 0, 100);
	        GridPane.setConstraints(players, 0, 0);
	        GridPane.setConstraints(names, 0, 1);
	        GridPane.setConstraints(taskLabel, 0, 50);
	        GridPane.setConstraints(taskField, 1, 50);
	        GridPane.setConstraints(estimationLabel, 0, 51);
	        GridPane.setConstraints(estimationField, 1, 51);
	        GridPane.setConstraints(estimateButton, 0, 52);
	        GridPane.setConstraints(resultLabel, 1, 52);


	        // Add elements to grid
	        grid.getChildren().addAll(taskLabel, taskField, estimationLabel, estimationField,
	        		estimateButton, resultLabel, players, names, aContainer, steps);

	        Scene scene = new Scene(grid, 1920, 1080);
	        primaryStage.setScene(scene);
	        primaryStage.getIcons().add(new Image("Ace-of-Spades.svg.png"));
	        primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
