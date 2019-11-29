/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public  class GamePad extends javax.swing.JPanel implements MouseListener, MouseMotionListener{
    boolean b = true;
    Rectangle r = new Rectangle(100,100,100,100);
    JButton butt = new JButton("Restart");
    int r1xdiff;
    int r1ydiff;
    public GamePad() {
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        butt.setBounds(10, 10, butt.getPreferredSize().width, butt.getPreferredSize().height);
        add(butt);
        
    }
    @Override
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
    }
}
