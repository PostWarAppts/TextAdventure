package main;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Driver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox();
		
		
		HBox topBar = new HBox();
		
		String[] labels = {"Map", "Inventory", "Party", "Status"};
		
		ArrayList<Button> topButtons = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Button b = new Button();
			b.setPrefSize(175, 50);
			b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			b.setText(labels[i]);
			Pane p = new Pane();
			Rectangle rect = new Rectangle(4, 4);
			rect.setLayoutX(171);
			rect.setLayoutY(48);
			Rectangle rect1 = new Rectangle(4, 4);
			rect1.setLayoutX(0);
			rect1.setLayoutY(48);
			p.getChildren().addAll(b, rect, rect1);
			topBar.getChildren().add(p);
			topButtons.add(b);
		}
		Pane main = new Pane();
		
		main.setPrefSize(700, 850);
		
		main.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 0 4 4 4");
		
		topButtons.get(0).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
		mapTab(main);
		
		topButtons.get(0).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(0).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			mapTab(main);
		});
		topButtons.get(1).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(1).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			inventoryTab(main);
		});
		topButtons.get(2).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(2).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			partyTab(main);
		});
		topButtons.get(3).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(3).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			statusTab(main);
		});
	
		
		root.getChildren().addAll(topBar, main);
		
		
		Scene scene = new Scene(root, 700, 900);
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public static void mapTab(Pane main) {
		main.getChildren().clear();
		Rectangle rect = new Rectangle(100, 100);
		rect.setLayoutY(400);
		rect.setLayoutX(300);
		Rectangle rect1 = new Rectangle(50, 50);
		rect1.setLayoutY(425);
		rect1.setLayoutX(325);
		rect1.setFill(Color.WHITE);
		main.getChildren().addAll(rect, rect1);
	}
	
	public static void inventoryTab(Pane main) {
		main.getChildren().clear();
	}
	
	public static void partyTab(Pane main) {
		main.getChildren().clear();
	}
	
	public static void statusTab(Pane main) {
		main.getChildren().clear();
	}

}
