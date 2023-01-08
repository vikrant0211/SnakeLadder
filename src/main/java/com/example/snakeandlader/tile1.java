package com.example.snakeandlader;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class tile1 extends Rectangle {
    public tile1 (int size){
        setWidth(size);
        setHeight(size);
        setFill(Color.RED);
        setStroke(Color.BLACK);
    }
}
