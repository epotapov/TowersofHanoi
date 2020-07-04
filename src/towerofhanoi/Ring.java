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
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author Edward Potapov
 */
public class Ring {
    int value;
    BufferedImage ring;
    Point p1;
    Point pO;
    public Ring(String file, int xin, int yin, int v) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream(file);
            ring = ImageIO.read(input);
        } catch (IOException e) {}
        p1 = new Point(xin - (ring.getWidth() / 2), yin);
        value = v;
    }
    void resize(int x, int y) {
        p1.x = x - (ring.getWidth() / 2);
        p1.y = y;
    }
    void setorigin() {
        pO = new Point(p1.x, p1.y);
    }
    void goBack() {
        p1 = new Point(pO.x, pO.y);
    }
}
