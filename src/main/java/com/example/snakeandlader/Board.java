package com.example.snakeandlader;

import java.util.ArrayList;
import javafx.util.Pair;

public class Board {
   private ArrayList<Pair<Integer,Integer>> positionCoordinates;
   private ArrayList<Integer> snakeLadderPosition;

    public Board(){
        populatePositionCoordinates();
        populateSnakeLadderPosition();
    }

    private void populatePositionCoordinates(){
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<Integer,Integer>(0,0));
        int x=1, y=10, xPos, yPos;
        for(int i=0; i<HelloApplication.hieght;i++){
            x=1;
            for(int j=0; j<HelloApplication.width; j++){
                if(y%2==0) {
                    xPos = x * HelloApplication.tile1Size - HelloApplication.tile1Size / 2;
                }
                else{
                    xPos = HelloApplication.width*HelloApplication.tile1Size -( x * HelloApplication.tile1Size - HelloApplication.tile1Size / 2);
                }
                yPos = y*HelloApplication.tile1Size - HelloApplication.tile1Size/2;
                positionCoordinates.add(new Pair<Integer,Integer>(xPos, yPos));
                x++;
            }
            y--;
        }
    }

    private void populateSnakeLadderPosition(){
        snakeLadderPosition = new ArrayList<>();
        for(int i=0; i<101; i++){
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(4,25);
        snakeLadderPosition.set(13,46);
        snakeLadderPosition.set(27,5);
        snakeLadderPosition.set(33,49);
        snakeLadderPosition.set(40,3);
        snakeLadderPosition.set(42,63);
        snakeLadderPosition.set(43,18);
        snakeLadderPosition.set(50,69);
        snakeLadderPosition.set(54,31);
        snakeLadderPosition.set(62,81);
        snakeLadderPosition.set(66,45);
        snakeLadderPosition.set(76,58);
        snakeLadderPosition.set(74,92);
        snakeLadderPosition.set(89,53);
        snakeLadderPosition.set(99,41);
    }

    public int getXCoordinate(int position){
        return positionCoordinates.get(position).getKey();
    }

    public int getYCoordinate(int position){
        return positionCoordinates.get(position).getValue();
    }

    public int getNextPosition(int position){
        if(position>=1 && position<=100) {
            return snakeLadderPosition.get(position);
        }
        else return -1;
    }

//    public static void main(String[] args) {
//        Board board = new Board();
//        board.populatePositionCoordinates();
//        for(int i=0; i<board.positionCoordinates.size(); i++){
//            System.out.println(i + "-> x:" + board.positionCoordinates.get(i).getKey() +
//                    " y:" + board.positionCoordinates.get(i).getValue());
//        }
//    }
}
