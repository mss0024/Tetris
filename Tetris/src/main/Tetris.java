/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

/**
 *
 * @author Mitch
 */
public class Tetris extends Container{
    public Tetris(Insets in)
    {
        this.setPreferredSize(new Dimension(700-in.left-in.right,700-in.top-in.bottom));
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
        JButton quitGame = new JButton("Exit");
        JLabel linesCleared = new JLabel("Lines Cleared: 0");
        JLabel score = new JLabel("Score: 0");
        
        
        this.add(quitGame);
        this.add(linesCleared);
        this.add(score);
        
        layout.putConstraint(SpringLayout.WEST, linesCleared, -200, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, linesCleared, -50, SpringLayout.SOUTH, this);
        
        layout.putConstraint(SpringLayout.NORTH, score, 10, SpringLayout.SOUTH, linesCleared);
        layout.putConstraint(SpringLayout.WEST, score, 0, SpringLayout.WEST, linesCleared);
        
        layout.putConstraint(SpringLayout.NORTH, quitGame, 5, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, quitGame, -5, SpringLayout.EAST, this);
        
        
        
        
        
        
        this.setVisible(true);
        
    }
    @Override
    public String toString()
    {
        return("TETRIS!!!");
    }
}
