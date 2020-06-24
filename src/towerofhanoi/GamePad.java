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

public  class GamePad extends JPanel implements MouseListener, MouseMotionListener{
    boolean b = true;
    boolean move = false;
    Rectangle r = new Rectangle(100,100,100,100);
    BufferedImage facedude;
    BufferedImage peg;
    int facedudex = 200;
    int facedudey = 200;
    int r1xdiff;
    int r1ydiff;
    public GamePad() {
        try {
            facedude = ImageIO.read(new File("src//Resources//facedude.png"));
            peg = ImageIO.read(new File("src//Resources//main-Peg.png"));
        }catch(IOException e) {}
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        int i = getY();
        if(b) {
            g.drawImage(peg, this.getWidth() / 4 - 15, 43, this);
            g.drawImage(peg, (this.getWidth() * 2) / 4 - 15, 43, this);
            g.drawImage(peg, (this.getWidth() * 3) / 4 - 15, 43, this);
            g.drawImage(facedude, facedudex, facedudey, this);
            //g.setColor(Color.black);
            //g.fillRect(r.x, r.y, r.width, r.height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
            facedudex = pt.x - r1xdiff;
            facedudey = pt.y - r1ydiff;
            b = true;
            repaint();
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Point pt = me.getPoint();
        if (pt.x >= facedudex && pt.y >= facedudey && pt.x <= (facedudex + facedude.getWidth()) && pt.y <= (facedudey + facedude.getHeight())) {
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Point pt = me.getPoint();
        if (pt.x >= facedudex && pt.y >= facedudey && pt.x <= (facedudex + facedude.getWidth()) && pt.y <= (facedudey + facedude.getHeight())) {
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            r1xdiff = pt.x - facedudex;
            r1ydiff = pt.y - facedudey;
            b = true;
            move = true;
            repaint();
        }
    }
}
