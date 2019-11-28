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
    boolean b = false;
    Rectangle r = new Rectangle(0,0,100,100);
    JButton butt = new JButton("Restart");
    
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
        b = false;
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
        if(b) {
           Point pt = me.getPoint();
           r.x = pt.x - r.width / 2;
           r.y = pt.y - r.height / 2;
           repaint(); 
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) 
    {
        Point pt = me.getPoint();
        r.x = pt.x - r.width / 2;
        r.y = pt.y - r.height / 2;
        b = true;
        repaint();
        
    }
}
