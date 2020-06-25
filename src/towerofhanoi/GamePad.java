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
    BufferedImage ring1;
    BufferedImage ring2;
    BufferedImage ring3;
    BufferedImage ring4;
    BufferedImage ring5;
    BufferedImage ring6;
    BufferedImage ring7;
    int facedudex = 200;
    int facedudey = 200;
    int r1xdiff;
    int r1ydiff;
    public GamePad() {
        try {
            facedude = ImageIO.read(new File("src//Resources//facedude.png"));
            peg = ImageIO.read(new File("src//Resources//main-Peg.png"));
            ring1 = ImageIO.read(new File("src//Resources//ring1.png"));
            ring2 = ImageIO.read(new File("src//Resources//ring2.png"));
            ring3 = ImageIO.read(new File("src//Resources//ring3.png"));
            ring4 = ImageIO.read(new File("src//Resources//ring4.png"));
            ring5 = ImageIO.read(new File("src//Resources//ring5.png"));
            ring6 = ImageIO.read(new File("src//Resources//ring6.png"));
            ring7 = ImageIO.read(new File("src//Resources//ring7.png"));
        }catch(IOException e) {}
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        for(int i = 1; i < 25; i++) {
            if (i == 5 || i == 12 || i == 19) {
                g.drawImage(peg, (this.getWidth() * i) / 24 - (peg.getWidth() / 2), (this.getHeight() - peg.getHeight()) / 2, this);
            }
            
        }
        g.drawImage(ring1, (this.getWidth() * 5) / 24 - (ring1.getWidth() / 2), ((this.getHeight() + peg.getHeight()) / 2) - 60, this);
        g.drawImage(ring2, (this.getWidth() * 5) / 24 - (ring2.getWidth() / 2), ((this.getHeight() + peg.getHeight()) / 2) - 120, this);
        g.drawImage(ring3, (this.getWidth() * 5) / 24 - (ring3.getWidth() / 2), ((this.getHeight() + peg.getHeight()) / 2) - 180, this);
        g.drawImage(ring4, (this.getWidth() * 5) / 24 - (ring4.getWidth() / 2), ((this.getHeight() + peg.getHeight()) / 2) - 240, this);
        g.drawImage(ring5, (this.getWidth() * 5) / 24 - (ring5.getWidth() / 2), ((this.getHeight() + peg.getHeight()) / 2) - 300, this);
        g.drawImage(ring6, (this.getWidth() * 5) / 24 - (ring6.getWidth() / 2), ((this.getHeight() + peg.getHeight()) / 2) - 360, this);
        g.drawImage(ring7, (this.getWidth() * 5) / 24 - (ring7.getWidth() / 2), ((this.getHeight() + peg.getHeight()) / 2) - 420, this);
        if(b) {
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
