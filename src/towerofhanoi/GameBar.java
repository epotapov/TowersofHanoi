/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Edward Potapov
 */
public class GameBar extends JPanel {
    JButton restartButt;
    JButton exampleButt;
    BoxLayout mainLayout;
    public GameBar() {
        restartButt = new JButton("Restart");
        exampleButt = new JButton("Example");
        mainLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        restartButt.addActionListener(e -> {
            System.out.println("yello");
        });
        setLayout(mainLayout);
        //setBackground(Color.GRAY);
        //this.setBorder(border);
        add(restartButt);
        add(exampleButt);
    }
}
