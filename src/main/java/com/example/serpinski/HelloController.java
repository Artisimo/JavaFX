package com.example.serpinski;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class HelloController {
    @FXML
    private AnchorPane pane;
    @FXML
    public void sierpinski(ActionEvent e){
        drawTriangle(25, 275, 200, 7);
    }

    @FXML
    public void rectangle(ActionEvent e){
        drawRectangle(350, 75, 200, 5);
    }

    public void drawTriangle(int x, int y, int size, int n){
        if(n<=0) {
            return;
        }

        int x1 = x;
        int y1 = y;
        int x2 = x1 + size;
        int y2 = y1;
        int x3 = (x1+x2)/2;
        int y3 = y1 - size;

        Line line = new Line(x1, y1, x2, y2);
        Line line2 = new Line(x1, y1, x3, y3);
        Line line3 = new Line(x2, y2, x3, y3);

        pane.getChildren().add(line);
        pane.getChildren().add(line2);
        pane.getChildren().add(line3);

        drawTriangle(x1, y1, size/2, n-1);
        drawTriangle((x1 + x2)/2, (y1 + y2)/2, size/2, n-1);
        drawTriangle((x1 + x3)/2, (y1+y3)/2, size/2, n-1);
    }

    public void drawRectangle(int x, int y, int size, int n){
        if(n<=0) {
            return;
        }

        int x1 = x;
        int y1 = y;
        int x2 = x + size;
        int y2 = y;
        int x3 = x;
        int y3 = y + size;
        int x4 = x + size;
        int y4 = y + size;

        Line line = new Line(x1, y1, x2, y2);
        Line line2 = new Line(x1, y1, x3, y3);
        Line line3 = new Line(x3, y3, x4, y4);
        Line line4 = new Line(x2, y2, x4, y4);

        pane.getChildren().add(line);
        pane.getChildren().add(line2);
        pane.getChildren().add(line3);
        pane.getChildren().add(line4);

        drawRectangle(x1, y1, size / 3, n-1);
        drawRectangle(x1, y1 + size / 3, size / 3, n-1);
        drawRectangle(x1, y1 + (size / 3) * 2, size / 3, n-1);
        drawRectangle(x1 + (size / 3), y1, size / 3, n-1);
        drawRectangle(x1 + (size / 3) * 2, y1, size / 3, n-1);
        drawRectangle(x1 + (size / 3), y1 + (size / 3) * 2, size / 3, n-1);
        drawRectangle(x1 + (size / 3) * 2, y1  + (size / 3) * 2, size / 3, n-1);
        drawRectangle(x1 + (size / 3) * 2, y1  + (size / 3), size / 3, n-1);
    }
}