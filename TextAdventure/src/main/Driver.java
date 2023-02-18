package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
					File file = new File(tx.getText() + ".txt");
					ArrayList<Button> topButtons = new ArrayList<>();
					
					Pane main = new Pane();
					main.setPrefSize(700, 850);
					main.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 0 4 4 4");
					
					mainStuff(topButtons, root);
					topButtonFunctions(topButtons, main, file);
					
					
					
					root.getChildren().add(main);
					
					
					
				} else {
					
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		stage.setTitle("Unnamed Land");
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
		String[] labels = {"Map", "Quests", "Inventory", "Status"};
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
		
		
		
		
		
		
	}
	
	
	public static void topButtonFunctions(ArrayList<Button> topButtons, Pane main, File file) {
		topButtons.get(0).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
		mapTab(main, file);
		
		topButtons.get(0).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(0).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			mapTab(main, file);
		});
		topButtons.get(1).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(1).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			questTab(main);
		});
		topButtons.get(2).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(2).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			inventoryTab(main);
		});
		topButtons.get(3).setOnAction(e -> {
			for(Button b : topButtons) {
				b.setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			}
			topButtons.get(3).setStyle("-fx-background-color: #ddcaaa; -fx-border-color: #000000 #000000 #ddcaaa; -fx-font-size: 20; -fx-border-width: 4 4 4 4");
			statusTab(main);
		});
	}
	
	
	
	public static void mapTab(Pane main, File file) {
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (Exception exp) {}
		ArrayList<String> arrr = new ArrayList<>();
		while(sc.hasNext()) {
			arrr.add(sc.nextLine());
		}
		
		
		Image image = null;
		Image image1 = null;
		main.getChildren().clear();
		try {
			image = new Image(new FileInputStream("images/image.png"));
			image1 = new Image(new FileInputStream("images/circle3.png"));
		} catch (Exception exp) {
		}
		ImageView map = new ImageView(image);
		ImageView circle = new ImageView(image1);
		
		circle.setLayoutX(336);
		circle.setLayoutY(211);
		
		Rectangle2D rect = new Rectangle2D(Integer.parseInt(arrr.get(0)), Integer.parseInt(arrr.get(1)), 500, 300);
		map.setViewport(rect);
		map.setLayoutX(100);
		map.setLayoutY(50);
		
		Rectangle mapBehind = new Rectangle(530, 330);
		mapBehind.setLayoutX(85);
		mapBehind.setLayoutY(35);
		
		Rectangle textBehind = new Rectangle(530, 230);
		textBehind.setLayoutX(85);
		textBehind.setLayoutY(415);
		
		TextField txfi = new TextField();
		txfi.setLayoutX(85);
		txfi.setLayoutY(645);
		txfi.setPrefWidth(530);
		txfi.setStyle("-fx-control-inner-background: #000000");
		String s = "";
		ArrayList<String> arr = new ArrayList<>();
		int y = -1;
		for(int i = 3; i < arrr.size(); i++) {
			if (arrr.get(i).equals("break")) {
				arr.add("");
				y++;
			} else {
				arr.set(y, arr.get(y) + arrr.get(i) + "\n");
			}
			
		}
		
		Button b = new Button();
		b.setLayoutX(500);
		b.setLayoutY(365);
		b.setStyle("-fx-shape: \"M 100 100 L 100 300 L 300 200 z\"; -fx-background-color: #000000");
		Button b1 = new Button();
		b1.setLayoutX(450);
		b1.setLayoutY(365);
		b1.setStyle("-fx-shape: \"M 300 100 L 300 300 L 100 200 z\"; -fx-background-color: #000000");
		int h = Integer.parseInt(arrr.get(2));
		Text t = new Text(arr.get(h));
		t.setLayoutX(95);
		t.setLayoutY(440);
		t.setFill(Color.WHITE);
		
		
		b.setOnAction(e -> {
			if (Integer.parseInt(arrr.get(2)) < arr.size()-1) {
				arrr.set(2, Integer.toString(Integer.parseInt(arrr.get(2)) + 1));
				t.setText(arr.get(Integer.parseInt(arrr.get(2))));
				writing(file, arrr);
			}
		});
		b1.setOnAction(e -> {
			if (Integer.parseInt(arrr.get(2)) > 0) {
				arrr.set(2, Integer.toString(Integer.parseInt(arrr.get(2)) - 1));
				t.setText(arr.get(Integer.parseInt(arrr.get(2))));
				writing(file, arrr);
			}
		});
		
		main.getChildren().addAll(mapBehind, map, circle, textBehind, t, b, b1);
	}
	
	
	
	public static void writing(File file, ArrayList<String> arr) {
		FileWriter writer = null;
		try { writer = new FileWriter(file); } catch (IOException e) {}
		for (int i = 0; i < arr.size(); i++) {
			try {
				if (i != 0) {
					writer.write("\r\n" + arr.get(i));
				} else {
					writer.write(arr.get(i));
				}
			} catch (IOException e) {}
		}
		try { writer.close(); } catch (IOException e) {}
	}
	
	
	
	
	public static void l(Pane main, String[] arr, int t, int v) {
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
					//mapTab(main, arr, t+55, v);
				} else if (txfi.getText().equals("E") || txfi.getText().equals("e")) {
					arr[0] = arr[1];
					arr[1] = arr[2];
					arr[2] = arr[3];
					arr[4] = arr[5];
					arr[5] = arr[6];
					arr[6] = arr[7];
					arr[7] = txfi.getText();
					//mapTab(main, arr, t, v+55);
				} else if (txfi.getText().equals("N") || txfi.getText().equals("n")) {
					arr[0] = arr[1];
					arr[1] = arr[2];
					arr[2] = arr[3];
					arr[4] = arr[5];
					arr[5] = arr[6];
					arr[6] = arr[7];
					arr[7] = txfi.getText();
					//mapTab(main, arr, t-55, v);
				} else if (txfi.getText().equals("W") || txfi.getText().equals("w")) {
					arr[0] = arr[1];
					arr[1] = arr[2];
					arr[2] = arr[3];
					arr[4] = arr[5];
					arr[5] = arr[6];
					arr[6] = arr[7];
					arr[7] = txfi.getText();
					//mapTab(main, arr, t, v-55);
				}
			}
		});
		
	}
	
	public static void questTab(Pane main) {
		main.getChildren().clear();
	}
	
	public static void inventoryTab(Pane main) {
		main.getChildren().clear();
	}
	
	public static void statusTab(Pane main) {
		main.getChildren().clear();
	}

}
