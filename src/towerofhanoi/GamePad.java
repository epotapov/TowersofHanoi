/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.Point;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import javafx.scene.layout.Pane;

/**
 *
 * @author Edward Potapov
 */
public  class GamePad extends Pane implements EventHandler<MouseEvent>{
    boolean b = false;
    Rectangle r = new Rectangle(100,100,100,100);
    double Rx;
    double Ry;
    double r1xdiff;
    double r1ydiff;
    public GamePad() {
        addEventHandler(MouseEvent.ANY, this);
        draw();
        //addMouseListener(this);
        //addMouseMotionListener(this);
    }
    void draw() {
        setStyle("-fx-background-color: red;");
        getChildren().add(r);
    }
    @Override
    public void handle(MouseEvent t) {
        int i = 0;
        if(t.getButton() == MouseButton.PRIMARY) {
            if(t.getEventType() == MouseEvent.MOUSE_PRESSED) {
                Point2D pt = new Point2D(t.getX(),t.getY());
                if (pt.getX() >= r.getX() && pt.getY() >= r.getY() && pt.getX() <= (r.getX() + r.getWidth()) && pt.getY() <= (r.getY() + r.getHeight())) {
                    r1xdiff = pt.getX() - r.getX();
                    r1ydiff = pt.getY() - r.getY();
                    b = true;
                }
            }
            else if(t.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                Point2D pt = new Point2D(t.getX(),t.getY());
                if(b) {
                    Rx = pt.getX() - r1xdiff;
                    Ry = pt.getY() - r1ydiff;
                    r.setX(Rx);
                    r.setY(Ry);
                }
            }
            else if(t.getEventType() == MouseEvent.MOUSE_RELEASED) {
                r.setX(Rx);
                r.setY(Ry);
                b = false;
            }
        }
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
