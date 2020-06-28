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
public class GameBar extends JToolBar {
    JButton restartButt;
    JButton upArrow;
    JButton downArrow;
    JTextField difficulty;
    String[] dLevel = {"3","4","5","6","7"};
    int level;
    JPanel panel;
    BoxLayout mainLayout;
    public GameBar(GamePad p) {
        panel = new JPanel();
        restartButt = new JButton("Restart");
        downArrow = new JButton("◄");
        downArrow.setPreferredSize(new Dimension(46, 25));
        downArrow.setEnabled(false);
        difficulty = new JTextField(dLevel[0]);
        level = 0;
        difficulty.setPreferredSize(new Dimension(20, 25));
        difficulty.setEditable(false);
        upArrow = new JButton("►");
        upArrow.setPreferredSize(new Dimension(46, 25));
        restartButt.setPreferredSize(new Dimension(80, 25));
        //mainLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        restartButt.addActionListener(e -> {
            p.restartRings(level);
        });
        downArrow.addActionListener(e -> {
            difficulty.setText(dLevel[level - 1]);
            level--;
            if(level == 0) {
                downArrow.setEnabled(false);
            } else {
                downArrow.setEnabled(true);
                upArrow.setEnabled(true);
            }
            p.restartRings(level);
        });
        upArrow.addActionListener(e -> {
            difficulty.setText(dLevel[level + 1]);
            level++;
            if(level == dLevel.length - 1) {
                upArrow.setEnabled(false);
            } else {
                downArrow.setEnabled(true);
                upArrow.setEnabled(true);
            }
            p.restartRings(level);
        });
        //setLayout(mainLayout);
        //add(tb);
        panel.add(restartButt);
        panel.add(downArrow);
        panel.add(difficulty);
        panel.add(upArrow);
        int i = restartButt.getHeight();
        add(panel);
    }
}
