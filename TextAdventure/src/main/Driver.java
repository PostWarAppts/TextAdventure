package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Driver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox();
		
		Pane p = new Pane();
		
		Image image = null;
		try {
			image = new Image(new FileInputStream("images/cover2.png"));
		} catch (Exception exp) {
		}
		ImageView view = new ImageView(image);
		TextField tx = new TextField();
		
		tx.setLayoutX(85);
		tx.setLayoutY(645);
		tx.setPrefWidth(530);
		tx.setPrefHeight(50);
		
		tx.setStyle("-fx-text-fill: white; -fx-background-color: black");
		
		p.getChildren().addAll(view, tx);
		root.getChildren().add(p);
		Scene scene = new Scene(root, 700, 900);
		
		tx.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				if (tx.getText().equals("1") || tx.getText().equals("2") || tx.getText().equals("3") || tx.getText().equals("4") || tx.getText().equals("5") || tx.getText().equals("6")) {
					root.getChildren().clear();
					File file = new File(Integer.toString(1) + ".txt");
					Scanner sc = null;
					try {
						sc = new Scanner(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(sc.nextLine());
					int s = Integer.parseInt(sc.nextLine());
					
					ArrayList<Button> topButtons = new ArrayList<>();
					
					Pane main = new Pane();
					
					main.setPrefSize(700, 850);
					
					
					main.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 0 4 4 4");
					
					
					mainStuff(topButtons, root);
					
					root.getChildren().add(main);
				} else {
					
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		stage.setTitle("Role-Playing Game");
		try {
			stage.getIcons().add(new Image(new FileInputStream("images/circle3.png")));
		} catch (Exception exp) {
			
		}
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	
	public static void mainStuff(ArrayList<Button> topButtons, VBox root) {
		String[] labels = {"Map", "Inventory", "Party", "Status"};
		HBox topBar = new HBox();
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
		
		root.getChildren().add(topBar);
		
		topButtons.get(0).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");

		
		topButtons.get(0).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(0).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			
		});
		topButtons.get(1).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(1).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");

		});
		topButtons.get(2).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(2).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");

		});
		topButtons.get(3).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(3).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
		});
		
		
		
		
	}
	
	public static void mapTab(Pane main, String[] arr, int t, int v) {
		Image image = null;
		Image image1 = null;
		main.getChildren().clear();
		try {
			image = new Image(new FileInputStream("images/image (2).png"));
			image1 = new Image(new FileInputStream("images/circle3.png"));
		} catch (Exception exp) {
		}
		ImageView view = new ImageView(image);
		Rectangle2D rect = new Rectangle2D(v, t, 500, 300);
		view.setViewport(rect);
		view.setLayoutX(100);
		view.setLayoutY(50);
		Rectangle r = new Rectangle(530, 330);
		r.setLayoutX(85);
		r.setLayoutY(35);
		ImageView view1 = new ImageView(image1);
		view1.setLayoutX(146);
		view1.setLayoutY(96);
		
		Rectangle r1 = new Rectangle(530, 230);
		r1.setLayoutX(85);
		r1.setLayoutY(415);
		
				
		
		Text tx = new Text(arr[0] + "\n" + arr[1] + "\n" + arr[2] + "\n" + arr[3] + "\n" + arr[4] + "\n" + arr[5] + "\n" + arr[6] + "\n" + arr[7]);
		tx.setLayoutX(95);
		tx.setLayoutY(440);
		tx.setFill(Color.WHITE);
		
		TextField txfi = new TextField();
		txfi.setLayoutX(85);
		txfi.setLayoutY(645);
		txfi.setPrefWidth(530);
		main.getChildren().addAll(r, view, view1, r1, tx, txfi);
		
		
		
		txfi.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				if (txfi.getText().equals("S") || txfi.getText().equals("s")) {
					arr[0] = arr[1];
					arr[1] = arr[2];
					arr[2] = arr[3];
					arr[4] = arr[5];
					arr[5] = arr[6];
					arr[6] = arr[7];
					arr[7] = txfi.getText();
					mapTab(main, arr, t+55, v);
				} else if (txfi.getText().equals("E") || txfi.getText().equals("e")) {
					arr[0] = arr[1];
					arr[1] = arr[2];
					arr[2] = arr[3];
					arr[4] = arr[5];
					arr[5] = arr[6];
					arr[6] = arr[7];
					arr[7] = txfi.getText();
					mapTab(main, arr, t, v+55);
				} else if (txfi.getText().equals("N") || txfi.getText().equals("n")) {
					arr[0] = arr[1];
					arr[1] = arr[2];
					arr[2] = arr[3];
					arr[4] = arr[5];
					arr[5] = arr[6];
					arr[6] = arr[7];
					arr[7] = txfi.getText();
					mapTab(main, arr, t-55, v);
				} else if (txfi.getText().equals("W") || txfi.getText().equals("w")) {
					arr[0] = arr[1];
					arr[1] = arr[2];
					arr[2] = arr[3];
					arr[4] = arr[5];
					arr[5] = arr[6];
					arr[6] = arr[7];
					arr[7] = txfi.getText();
					mapTab(main, arr, t, v-55);
				}
			}
		});
		
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
