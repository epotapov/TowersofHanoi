/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.BorderLayout;
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
    static GamePad gamer;
    static GameBar gb;
    public static void main(String[] args) {
        window = new JFrame("Towers of Hanoi");
        gameTitle = new JLabel("Towers of Hanoi");
        startGame = new JButton("Let's Play");
        homePanel = new JPanel();
        bl = new BoxLayout(homePanel, BoxLayout.Y_AXIS);
        f = new Font("Rockwell", Font.PLAIN,90);
        gameTitle.setFont(f);
        homePanel.setLayout(bl);
        startGame.setPreferredSize(new Dimension(40, 40));
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.addActionListener(e -> {
            //window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
            window.getContentPane().setLayout(new BorderLayout());
            gamer = new GamePad();
            gb = new GameBar(gamer);
            gamer.addGameBar(gb);
            window.getContentPane().add(gb, BorderLayout.NORTH);
            window.getContentPane().add(gamer, BorderLayout.CENTER);
            //gb.setSize(new Dimension(window.getWidth(),100));
            window.remove(homePanel);
            window.setVisible(true);
        });
        window.setSize(1200, 600);
        window.setMinimumSize(new Dimension(1200, 600));
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
