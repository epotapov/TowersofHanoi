/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;
/**
 *
 * @author Edward Potapov
 */
public class TheTowers {
    static JFrame window;
    static JPanel homePanel;
    static JLabel gameTitle;
    static JButton startGame;
    static BoxLayout bl;
    public static void main(String[] args) {
        window = new JFrame("Towers of Hanoi");
        gameTitle = new JLabel("Towers of Hanoi");
        startGame = new JButton("Let's Play");
        homePanel = new JPanel();
        bl = new BoxLayout(homePanel, BoxLayout.Y_AXIS);
        homePanel.setLayout(bl);
        startGame.setPreferredSize(new Dimension(30, 20));
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.addActionListener(e -> {
            GamePad gamer = new GamePad();
            window.remove(homePanel);
            window.add(gamer);
            window.setVisible(true);
        });
        homePanel.add(gameTitle);
        homePanel.add(startGame);
        window.setSize(800, 550);
        window.setMinimumSize(new Dimension(800, 550));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(homePanel);
        window.setVisible(true);
    }
}
