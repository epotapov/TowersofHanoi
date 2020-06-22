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
import java.awt.Font;
/**
 *
 * @author Edward Potapov
 */
public class TheTowers {
    public static JFrame window;
    static JPanel homePanel;
    static JLabel gameTitle;
    static JButton startGame;
    static BoxLayout bl;
    static Font f;
    public static void main(String[] args) {
        window = new JFrame("Towers of Hanoi");
        gameTitle = new JLabel("Towers of Hanoi");
        startGame = new JButton("Let's Play");
        homePanel = new JPanel();
        bl = new BoxLayout(homePanel, BoxLayout.Y_AXIS);
        f = new Font("Rockwell", Font.PLAIN,70);
        gameTitle.setFont(f);
        homePanel.setLayout(bl);
        startGame.setPreferredSize(new Dimension(30, 20));
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.addActionListener(e -> {
            window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
            GamePad gamer = new GamePad();
            GameBar gb = new GameBar();
            window.getContentPane().add(gb);
            window.getContentPane().add(gamer);
            //gb.setSize(new Dimension(window.getWidth(),100));
            window.remove(homePanel);
            window.setVisible(true);
        });
        window.setSize(800, 550);
        window.setMinimumSize(new Dimension(800, 550));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int i = window.getHeight() / 2;
        homePanel.add(Box.createRigidArea(new Dimension(0, window.getHeight() / 4)));
        homePanel.add(gameTitle);
        homePanel.add(Box.createRigidArea(new Dimension(0, window.getHeight() / 5)));
        homePanel.add(startGame);
        window.getContentPane().add(homePanel);
        window.setVisible(true);
    }
}
