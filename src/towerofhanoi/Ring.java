/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Edward Potapov
 */
public class Ring {
    BufferedImage ring;
    Point p1;
    Point p2;
    public Ring(String file, int xin, int yin) {
        try {
            ring = ImageIO.read(new File(file));
        } catch (IOException e) {}
        p1 = new Point(xin - (ring.getWidth() / 2), yin);
        p2 = new Point(p1.x + ring.getWidth(), p1.y + ring.getHeight());
    }
    void resize(int x, int y) {
        p1.x = x - (ring.getWidth() / 2);
        p1.y = y;
        p2.x = p1.x + ring.getWidth();
        p2.y = p1.y + ring.getHeight();
    }
}
