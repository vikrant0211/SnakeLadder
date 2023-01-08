package com.example.snakeandlader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static final int tile1Size = 40, hieght=10, width=10 ;
    int lowerLine =tile1Size*hieght;
    int diceValue;

    Label rolledDiceVlueLabel ;

    boolean firstPlayerTurn = true, secondPlayerTurn = false, gameStarted = false;

    Button startGmeButton;

    players firstPlayer = new players(tile1Size, Color.BLACK, "Amit");
    players secondPlayer = new players(tile1Size-10, Color.WHITE, "Vinay");


    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tile1Size, hieght*tile1Size+100);
        for(int i=0;i<width;i++){
            for(int j=0;j<hieght;j++){
                tile1 tile =new tile1(tile1Size);
                tile.setTranslateX(j*tile1Size);
                tile.setTranslateY(i*tile1Size);
                root.getChildren().add(tile);
            }
        }
        Image img =new Image("C:\\Users\\vikra\\IdeaProjects\\snakeandlader\\src\\istockphoto-531466314-612x612.jpg");
        ImageView borderImage = new ImageView();
        borderImage.setImage(img);
        borderImage.setFitWidth(tile1Size*width);
        borderImage.setFitHeight(tile1Size*hieght);


        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(lowerLine+20);

        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(firstPlayerTurn){
                        setDiceValue();
                        firstPlayer.movePlayer(diceValue);
                        if(firstPlayer.playerWon() != null){
                            rolledDiceVlueLabel.setText(firstPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGmeButton.setDisable(false);
                            startGmeButton.setText("Start Game");
                    }
                        firstPlayerTurn = false;
                        secondPlayerTurn = true;
                }

                }
            }
        });
        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(300);
        playerTwoButton.setTranslateY(lowerLine+20);

        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(secondPlayerTurn){
                        setDiceValue();
                        secondPlayer.movePlayer(diceValue);
                        if(secondPlayer.playerWon() != null){
                            rolledDiceVlueLabel.setText(secondPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGmeButton.setDisable(false);
                            startGmeButton.setText("Start game");
                    }
                        secondPlayerTurn = false;
                        firstPlayerTurn = true;
                }

                }
            }
        });

         startGmeButton = new Button("Start");
         startGmeButton.setTranslateX(150);
         startGmeButton.setTranslateY(lowerLine+50);
         startGmeButton.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent actionEvent) {
                 gameStarted = true;
                 startGmeButton.setText("Ongoing Game");
                 startGmeButton.setDisable(true);
             }
         });


        rolledDiceVlueLabel = new Label("Start the Game");
        rolledDiceVlueLabel.setTranslateY(lowerLine+20);
        rolledDiceVlueLabel.setTranslateX(150);

        root.getChildren().addAll(borderImage, playerOneButton, playerTwoButton, firstPlayer.getCoin(), secondPlayer.getCoin(), rolledDiceVlueLabel, startGmeButton);

        return root;
    }

    public void setDiceValue(){
         diceValue = (int)(Math.random()*6+1);
         rolledDiceVlueLabel.setText("Dice Value : " +diceValue);
    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & lader");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}