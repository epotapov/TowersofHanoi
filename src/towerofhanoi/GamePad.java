/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.Rectangle;
import java.awt.event.*;
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

public  class GamePad extends Scene {
    boolean b = true;
    Rectangle r = new Rectangle(100,100,100,100);
    int r1xdiff;
    int r1ydiff;
    public GamePad() {
        super(null);
        //addMouseListener(this);
        //addMouseMotionListener(this);
        
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
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
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
