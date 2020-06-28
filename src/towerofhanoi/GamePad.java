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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public  class GamePad extends JPanel implements MouseListener, MouseMotionListener, ComponentListener{

    boolean move = false;
    boolean firsttime = true;
    boolean refresh = false;
    boolean last = false;
    boolean nonemovable = false;
    ArrayList<Ring> peg1;
    ArrayList<Ring> peg2;
    ArrayList<Ring> peg3;
    Point ppeg1;
    Point ppeg2;
    Point ppeg3;
    BufferedImage facedude;
    BufferedImage peg;
    int whicharray = 0;
    int r1xdiff;
    int r1ydiff;
    public GamePad() {
        peg1 = new ArrayList<Ring>();
        peg2 = new ArrayList<Ring>();
        peg3 = new ArrayList<Ring>();
        try {
            peg = ImageIO.read(new File("src//Resources//main-Peg.png"));
        }catch(IOException e) {}
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    void ringsAdded() { //base game number of rings can be altered
        peg1.add(new Ring("src//Resources//ring1.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 60, 7));
        peg1.add(new Ring("src//Resources//ring2.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 120, 6));
        peg1.add(new Ring("src//Resources//ring3.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 180, 5));
    }
    
    void restartRings(int number) {
        peg1.clear();
        peg2.clear();
        peg3.clear();
        switch(number) {
            case 0:
                peg1.add(new Ring("src//Resources//ring1.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 60, 7));
                peg1.add(new Ring("src//Resources//ring2.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 120, 6));
                peg1.add(new Ring("src//Resources//ring3.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 180, 5));
                break;
            case 1:
                peg1.add(new Ring("src//Resources//ring1.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 60, 7));
                peg1.add(new Ring("src//Resources//ring2.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 120, 6));
                peg1.add(new Ring("src//Resources//ring3.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 180, 5));
                peg1.add(new Ring("src//Resources//ring4.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 240, 4));
                break;
            case 2:
                peg1.add(new Ring("src//Resources//ring1.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 60, 7));
                peg1.add(new Ring("src//Resources//ring2.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 120, 6));
                peg1.add(new Ring("src//Resources//ring3.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 180, 5));
                peg1.add(new Ring("src//Resources//ring4.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 240, 4));
                peg1.add(new Ring("src//Resources//ring5.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 300, 3));
                break;
            case 3:
                peg1.add(new Ring("src//Resources//ring1.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 60, 7));
                peg1.add(new Ring("src//Resources//ring2.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 120, 6));
                peg1.add(new Ring("src//Resources//ring3.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 180, 5));
                peg1.add(new Ring("src//Resources//ring4.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 240, 4));
                peg1.add(new Ring("src//Resources//ring5.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 300, 3));
                peg1.add(new Ring("src//Resources//ring6.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 360, 2));
                break;
            case 4:
                peg1.add(new Ring("src//Resources//ring1.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 60, 7));
                peg1.add(new Ring("src//Resources//ring2.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 120, 6));
                peg1.add(new Ring("src//Resources//ring3.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 180, 5));
                peg1.add(new Ring("src//Resources//ring4.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 240, 4));
                peg1.add(new Ring("src//Resources//ring5.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 300, 3));
                peg1.add(new Ring("src//Resources//ring6.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 360, 2));
                peg1.add(new Ring("src//Resources//ring7.png",(this.getWidth() * 5) / 24,((this.getHeight() + peg.getHeight()) / 2) - 420, 1));
                break;
            default:
                break;
        
        }
        
        whicharray = 0;
        repaint();
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        for(int i = 0; i < peg1.size(); i++) {
            peg1.get(i).resize((this.getWidth() * 5) / 24, ((this.getHeight() + peg.getHeight()) / 2) - (60 * (i + 1)));
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if(firsttime) {
            ringsAdded();
            firsttime = false;
        }
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        for(int i = 1; i < 25; i++) {
            if (i == 5 || i == 12 || i == 19) {
                
                g.drawImage(peg, (this.getWidth() * i) / 24 - (peg.getWidth() / 2), (this.getHeight() - peg.getHeight()) / 2, this);
                if(i == 5) 
                    ppeg1 = new Point((this.getWidth() * 5) / 24 - (peg.getWidth() / 2), (this.getHeight() - peg.getHeight()) / 2);
                if(i == 12)
                    ppeg2 = new Point((this.getWidth() * 12) / 24 - (peg.getWidth() / 2), (this.getHeight() - peg.getHeight()) / 2);
                if(i == 19)
                    ppeg3 = new Point((this.getWidth() * 19) / 24 - (peg.getWidth() / 2), (this.getHeight() - peg.getHeight()) / 2);
                
            }
        }
        for(int i = 0; i < peg1.size() - ((whicharray == 1)?1:0); i++) {
            g.drawImage(peg1.get(i).ring, peg1.get(i).p1.x, peg1.get(i).p1.y, this);  
        }
        for(int i = 0; i < peg2.size() - ((whicharray == 2)?1:0); i++) {
            g.drawImage(peg2.get(i).ring, peg2.get(i).p1.x, peg2.get(i).p1.y, this);
        }
        for(int i = 0; i < peg3.size() - ((whicharray == 3)?1:0); i++) {
            g.drawImage(peg3.get(i).ring, peg3.get(i).p1.x, peg3.get(i).p1.y, this);
        }
        switch (whicharray) {
            case 1:
                g.drawImage(peg1.get(peg1.size() - 1).ring, peg1.get(peg1.size() - 1).p1.x, peg1.get(peg1.size() - 1).p1.y, this);
                break;
            case 2:
                g.drawImage(peg2.get(peg2.size() - 1).ring, peg2.get(peg2.size() - 1).p1.x, peg2.get(peg2.size() - 1).p1.y, this);
                break;    
            case 3:
                g.drawImage(peg3.get(peg3.size() - 1).ring, peg3.get(peg3.size() - 1).p1.x, peg3.get(peg3.size() - 1).p1.y, this);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        move = false;
        switch(whicharray) {
            case 1:
                Point one = new Point(Math.max(peg1.get(peg1.size() - 1).p1.x, ppeg2.x), Math.max(peg1.get(peg1.size() - 1).p1.y, ppeg2.y));
                Point two  = new Point(Math.min(peg1.get(peg1.size() - 1).p1.x + peg1.get(peg1.size() - 1).ring.getWidth(), ppeg2.x + peg.getWidth()),Math.min(peg1.get(peg1.size() - 1).p1.y + peg1.get(peg1.size() - 1).ring.getHeight(), ppeg2.y + peg.getHeight()));
                Point three = new Point(Math.max(peg1.get(peg1.size() - 1).p1.x, ppeg3.x), Math.max(peg1.get(peg1.size() - 1).p1.y, ppeg3.y));
                Point four = new Point(Math.min(peg1.get(peg1.size() - 1).p1.x + peg1.get(peg1.size() - 1).ring.getWidth(), ppeg3.x + peg.getWidth()),Math.min(peg1.get(peg1.size() - 1).p1.y + peg1.get(peg1.size() - 1).ring.getHeight(), ppeg3.y + peg.getHeight()));
                if (one.x < two.x && one.y < two.y) {
                    if((!peg2.isEmpty() && peg1.get(peg1.size() - 1).value < peg2.get(peg2.size() - 1).value) || peg2.isEmpty()) {
                        peg2.add(peg1.get(peg1.size() - 1));
                        peg1.remove(peg1.size() - 1);
                        whicharray = 2;
                        peg2.get(peg2.size() - 1).p1 = new Point((this.getWidth() * 12) / 24 - (peg2.get(peg2.size() - 1).ring.getWidth() / 2),((this.getHeight() + peg.getHeight()) / 2) - (60 * peg2.size()) );
                    } else {
                        peg1.get(peg1.size() - 1).goBack();
                    }
                }else if (three.x < four.x && three.y < four.y) {
                    if((!peg3.isEmpty() && peg1.get(peg1.size() - 1).value < peg3.get(peg3.size() - 1).value) || peg3.isEmpty()) {
                        peg3.add(peg1.get(peg1.size() - 1));
                        peg1.remove(peg1.size() - 1);
                        whicharray = 3;
                        peg3.get(peg3.size() - 1).p1 = new Point((this.getWidth() * 19) / 24 - (peg3.get(peg3.size() - 1).ring.getWidth() / 2),((this.getHeight() + peg.getHeight()) / 2) - (60 * peg3.size()) );
                    } else {
                        peg1.get(peg1.size() - 1).goBack();
                    }
                } else {
                    peg1.get(peg1.size() - 1).goBack();
                }
                repaint();
                break;
            case 2:
                Point o = new Point(Math.max(peg2.get(peg2.size() - 1).p1.x, ppeg1.x), Math.max(peg2.get(peg2.size() - 1).p1.y, ppeg1.y));
                Point t  = new Point(Math.min(peg2.get(peg2.size() - 1).p1.x + peg2.get(peg2.size() - 1).ring.getWidth(), ppeg1.x + peg.getWidth()),Math.min(peg2.get(peg2.size() - 1).p1.y + peg2.get(peg2.size() - 1).ring.getHeight(), ppeg1.y + peg.getHeight()));
                Point th = new Point(Math.max(peg2.get(peg2.size() - 1).p1.x, ppeg3.x), Math.max(peg2.get(peg2.size() - 1).p1.y, ppeg3.y));
                Point f = new Point(Math.min(peg2.get(peg2.size() - 1).p1.x + peg2.get(peg2.size() - 1).ring.getWidth(), ppeg3.x + peg.getWidth()),Math.min(peg2.get(peg2.size() - 1).p1.y + peg2.get(peg2.size() - 1).ring.getHeight(), ppeg3.y + peg.getHeight()));
                if (o.x < t.x && o.y < t.y) {
                    if((!peg1.isEmpty() && peg2.get(peg2.size() - 1).value < peg1.get(peg1.size() - 1).value) || peg1.isEmpty()) {
                        peg1.add(peg2.get(peg2.size() - 1));
                        peg2.remove(peg2.size() - 1);
                        whicharray = 1;
                        peg1.get(peg1.size() - 1).p1 = new Point((this.getWidth() * 5) / 24 - (peg1.get(peg1.size() - 1).ring.getWidth() / 2),((this.getHeight() + peg.getHeight()) / 2) - (60 * peg1.size()) );
                    } else {
                        peg2.get(peg2.size() - 1).goBack();
                    }
                }else if (th.x < f.x && th.y < f.y) {
                    if((!peg3.isEmpty() && peg2.get(peg2.size() - 1).value < peg3.get(peg3.size() - 1).value) || peg3.isEmpty()) {
                        peg3.add(peg2.get(peg2.size() - 1));
                        peg2.remove(peg2.size() - 1);
                        whicharray = 3;
                        peg3.get(peg3.size() - 1).p1 = new Point((this.getWidth() * 19) / 24 - (peg3.get(peg3.size() - 1).ring.getWidth() / 2),((this.getHeight() + peg.getHeight()) / 2) - (60 * peg3.size()) );
                    } else {
                        peg2.get(peg2.size() - 1).goBack();
                    }
                } else {
                    peg2.get(peg2.size() - 1).goBack();
                }
                repaint();
                break;
            case 3:
                Point a = new Point(Math.max(peg3.get(peg3.size() - 1).p1.x, ppeg1.x), Math.max(peg3.get(peg3.size() - 1).p1.y, ppeg1.y));
                Point b  = new Point(Math.min(peg3.get(peg3.size() - 1).p1.x + peg3.get(peg3.size() - 1).ring.getWidth(), ppeg1.x + peg.getWidth()),Math.min(peg3.get(peg3.size() - 1).p1.y + peg3.get(peg3.size() - 1).ring.getHeight(), ppeg1.y + peg.getHeight()));
                Point c = new Point(Math.max(peg3.get(peg3.size() - 1).p1.x, ppeg2.x), Math.max(peg3.get(peg3.size() - 1).p1.y, ppeg2.y));
                Point d = new Point(Math.min(peg3.get(peg3.size() - 1).p1.x + peg3.get(peg3.size() - 1).ring.getWidth(), ppeg2.x + peg.getWidth()),Math.min(peg3.get(peg3.size() - 1).p1.y + peg3.get(peg3.size() - 1).ring.getHeight(), ppeg2.y + peg.getHeight()));
                if (a.x < b.x && a.y < b.y) {
                    if((!peg1.isEmpty() && peg3.get(peg3.size() - 1).value < peg1.get(peg1.size() - 1).value) || peg1.isEmpty()) {
                        peg1.add(peg3.get(peg3.size() - 1));
                        peg3.remove(peg3.size() - 1);
                        whicharray = 1;
                        peg1.get(peg1.size() - 1).p1 = new Point((this.getWidth() * 5) / 24 - (peg1.get(peg1.size() - 1).ring.getWidth() / 2),((this.getHeight() + peg.getHeight()) / 2) - (60 * peg1.size()) );
                    } else {
                        peg3.get(peg3.size() - 1).goBack();
                    }
                }else if (c.x < d.x && c.y < d.y) {
                    if((!peg2.isEmpty() && peg3.get(peg3.size() - 1).value < peg2.get(peg2.size() - 1).value) || peg2.isEmpty()) {
                        peg2.add(peg3.get(peg3.size() - 1));
                        peg3.remove(peg3.size() - 1);
                        whicharray = 2;
                        peg2.get(peg2.size() - 1).p1 = new Point((this.getWidth() * 12) / 24 - (peg2.get(peg2.size() - 1).ring.getWidth() / 2),((this.getHeight() + peg.getHeight()) / 2) - (60 * peg2.size()) );
                    } else {
                        peg3.get(peg3.size() - 1).goBack();
                    }
                } else {
                    peg3.get(peg3.size() - 1).goBack();
                }
                repaint();
                break;
            default:
                break;
        }
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
            switch(whicharray) {
                case 1:
                    peg1.get(peg1.size() - 1).p1.x = pt.x - r1xdiff;
                    peg1.get(peg1.size() - 1).p1.y = pt.y - r1ydiff;  
                    break;
                case 2: 
                    peg2.get(peg2.size() - 1).p1.x = pt.x - r1xdiff;
                    peg2.get(peg2.size() - 1).p1.y = pt.y - r1ydiff; 
                    break;
                case 3:
                    peg3.get(peg3.size() - 1).p1.x = pt.x - r1xdiff;
                    peg3.get(peg3.size() - 1).p1.y = pt.y - r1ydiff; 
                    break;
                default:
                    break;
            }
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Point pt = me.getPoint();
        /*for(int i = 0; i < peg1.size(); i++) {
            if (pt.x >= peg1.get(i).p1.x && pt.y >= peg1.get(i).p1.y && pt.x <= (peg1.get(i).p1.x + peg1.get(i).ring.getWidth()) && pt.y <= (peg1.get(i).p1.y + peg1.get(i).ring.getHeight())) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        }*/
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Point pt = me.getPoint();
        boolean first = false;
        if(peg1.size() > 0) {
            if (pt.x >= peg1.get(peg1.size() - 1).p1.x && pt.y >= peg1.get(peg1.size() - 1).p1.y && pt.x <= (peg1.get(peg1.size() - 1).p1.x + peg1.get(peg1.size() - 1).ring.getWidth()) && pt.y <= (peg1.get(peg1.size() - 1).p1.y + peg1.get(peg1.size() - 1).ring.getHeight())) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                whicharray = 1;
                r1xdiff = pt.x - peg1.get(peg1.size() - 1).p1.x;
                r1ydiff = pt.y - peg1.get(peg1.size() - 1).p1.y;
                peg1.get(peg1.size() - 1).setorigin();
                first = true;
                move = true;
            }
        }
        boolean second = false;
        if(peg2.size() > 0) {
            if (pt.x >= peg2.get(peg2.size() - 1).p1.x && pt.y >= peg2.get(peg2.size() - 1).p1.y && pt.x <= (peg2.get(peg2.size() - 1).p1.x + peg2.get(peg2.size() - 1).ring.getWidth()) && pt.y <= (peg2.get(peg2.size() - 1).p1.y + peg2.get(peg2.size() - 1).ring.getHeight())) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                whicharray = 2;
                r1xdiff = pt.x - peg2.get(peg2.size() - 1).p1.x;
                r1ydiff = pt.y - peg2.get(peg2.size() - 1).p1.y;
                peg2.get(peg2.size() - 1).setorigin();
                second = true;
                move = true;
            }
        }  
        boolean third = false;
        if(peg3.size() > 0) {
            if (pt.x >= peg3.get(peg3.size() - 1).p1.x && pt.y >= peg3.get(peg3.size() - 1).p1.y && pt.x <= (peg3.get(peg3.size() - 1).p1.x + peg3.get(peg3.size() - 1).ring.getWidth()) && pt.y <= (peg3.get(peg3.size() - 1).p1.y + peg3.get(peg3.size() - 1).ring.getHeight())) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                whicharray = 3;
                r1xdiff = pt.x - peg3.get(peg3.size() - 1).p1.x;
                r1ydiff = pt.y - peg3.get(peg3.size() - 1).p1.y;
                peg3.get(peg3.size() - 1).setorigin();
                third = true;
                move = true;
            }
        } 
        if(!first && !second && !third) {
            whicharray = 0;
        }
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
