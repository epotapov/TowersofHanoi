/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public  class GamePad extends javax.swing.JPanel implements MouseListener, MouseMotionListener{
    boolean b = true;
    boolean move = false;
    Rectangle r = new Rectangle(100,100,100,100);
    BufferedImage facedude;
    int r1xdiff;
    int r1ydiff;
    public GamePad() {
        try {
            facedude = ImageIO.read(new File("src//Resources//facedude.png"));
        }catch(IOException e) {}
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        int i = getY();
        if(b) {
            g.drawImage(facedude, 200, 200, this);
            //g.setColor(Color.black);
            //g.fillRect(r.x, r.y, r.width, r.height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        move = false;
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
        if (move) {
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
            move = true;
            repaint();
        }
    }
}
