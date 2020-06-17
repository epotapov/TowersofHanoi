/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Edward Potapov
 */
public class TheTowers extends Application {
    Scene startMenu;
    VBox layout;
    Button startGame;
    Label gameTitle;
    Font titleFont;
    
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Towers of Hanoi");
        layout = new VBox();
        gameTitle = new Label("Towers of Hanoi");
        titleFont = Font.font("Rockwell", FontWeight.BOLD, 70);
        gameTitle.setFont(titleFont);
        startMenu = new Scene(layout, 800, 550);
        startGame = new Button("Let's Play");
        titleFont = Font.font(20);
        startGame.setFont(titleFont);
        startGame.setOnAction(e -> System.out.println("Hello"));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(gameTitle);
        layout.getChildren().add(startGame);
        layout.setSpacing(100);
        primaryStage.setScene(startMenu);
        primaryStage.show();
    }
}
