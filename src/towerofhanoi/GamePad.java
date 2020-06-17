/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public  class GamePad extends Pane {
    boolean b = true;
    Rectangle r = new Rectangle(100,100,100,100);
    int r1xdiff;
    int r1ydiff;
    public GamePad() {
        draw();
        //addMouseListener(this);
        //addMouseMotionListener(this);
        
    }
    void draw() {
        setStyle("-fx-background-color: red;");
        getChildren().add(r);
    }
    /*@Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        
        if(b) {
            g.setColor(Color.black);
            g.fillRect(r.x, r.y, r.width, r.height);
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        Point pt = me.getPoint();
        if (pt.x >= r.x && pt.y >= r.y && pt.x <= (r.x + r.width) && pt.y <= (r.y + r.height)) {
            r.x = pt.x - r1xdiff;
            r.y = pt.y - r1ydiff;
            b = true;
            repaint();
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Point pt = me.getPoint();
        if (pt.x >= r.x && pt.y >= r.y && pt.x <= (r.x + r.width) && pt.y <= (r.y + r.height)) {
            r1xdiff = pt.x - r.x;
            r1ydiff = pt.y - r.y;
            r.x = pt.x - r1xdiff;
            r.y = pt.y - r1ydiff;
            b = true;
            repaint();
        }
    }*/
}
