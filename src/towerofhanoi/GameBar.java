/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
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
    JLabel time;
    Timer timer;
    TimerTask tasker;
    int minuteTime = 0;
    int secondTime = 0;
    JLabel timeRecord;
    String[] dLevel = {"3","4","5","6","7"};
    String[] RTimes = {"","","","",""};
    int record = 0;
    int[] RecordTimes = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,};
    int level;
    JPanel panel;
    BoxLayout mainLayout;
    GamePad gamer;
    public GameBar(GamePad p) {
        setFloatable(false);
        gamer = p;
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
            gamer.restartRings(level);
            timeStop(false);
            gamer.startTimer = true;
            gamer.continueGame = true;
        });
        downArrow.addActionListener(e -> {
            difficulty.setText(dLevel[level - 1]);
            level--;
            if(RecordTimes[level] != Integer.MAX_VALUE) {
                timeRecord.setText(RTimes[level]);
            } else
                timeRecord.setText("");
            gamer.level = level + 3; 
            gamer.continueGame = true;
            if(level == 0) {
                downArrow.setEnabled(false);
            } else {
                downArrow.setEnabled(true);
                upArrow.setEnabled(true);
            }
            timeStop(false);
            gamer.startTimer = true;
            gamer.restartRings(level);
        });
        upArrow.addActionListener(e -> {
            difficulty.setText(dLevel[level + 1]);
            level++;
            if(RecordTimes[level] != Integer.MAX_VALUE) {
                timeRecord.setText(RTimes[level]);
            } else
                timeRecord.setText("");
            gamer.level = level + 3; 
            gamer.continueGame = true;
            if(level == dLevel.length - 1) {
                upArrow.setEnabled(false);
            } else {
                downArrow.setEnabled(true);
                upArrow.setEnabled(true);
            }
            timeStop(false);
            gamer.startTimer = true;
            gamer.restartRings(level);
        });
        time = new JLabel(String.format("%02d", minuteTime) + ":" + String.format("%02d", secondTime));
        Font fsmall = TheTowers.f.deriveFont(20f);
        time.setFont(fsmall);
        timeRecord = new JLabel();
        timeRecord.setFont(fsmall);
        timeRecord.setForeground(Color.RED);
        //setLayout(mainLayout);
        //add(tb);
        panel.add(restartButt);
        panel.add(downArrow);
        panel.add(difficulty);
        panel.add(upArrow);
        panel.add(time);
        panel.add(timeRecord);
        int i = restartButt.getHeight();
        add(panel);
    }
    
    void timeFun() {
        timer = new Timer();
        tasker = new TimerTask() {
            public void run() {
                secondTime++;
                record++;
                timeFormat();
                time.setText(String.format("%02d", minuteTime) + ":" + String.format("%02d", secondTime));
            }
        };
        timer.scheduleAtFixedRate(tasker, 0, 1000);
    }
    
    void timeFormat() {
        if(secondTime == 60 ) {
            secondTime = 0;
            minuteTime++;
        }
        if(minuteTime == 60) {
            gamer.restartRings(level);
            timeStop(false);
            gamer.startTimer = true;
        }
    }
    
    void timeStop(boolean finished) {
        if(tasker != null) 
            tasker.cancel();
        if(record < RecordTimes[level] && finished) {
            timeRecord.setText(time.getText());
            RTimes[level] = time.getText();
            RecordTimes[level] = record;
        }
        record = 0;
        minuteTime = 0;
        secondTime = 0;
        time.setText(String.format("%02d", minuteTime) + ":" + String.format("%02d", secondTime));
    }
}
