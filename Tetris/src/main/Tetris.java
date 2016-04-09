/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import block.*;
import block.TBProperties.Shape;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Mitch
 */
public class Tetris extends Container{
    //tetriminos 25x25
    public void paint(Graphics g) {
        g.fillRoundRect(90,90,270,520,20,20);
        g.fillRoundRect(365,90,125,125,20,20);
        g.setColor(this.getBackground());
        g.fillRect(100,100,250,500);
        g.fillRect(375,100,105,105);
        
        this.paintComponents(g);
    }
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
        layout.putConstraint(SpringLayout.NORTH, score, 600, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, score, 370, SpringLayout.WEST, this);
        
        layout.putConstraint(SpringLayout.WEST, linesCleared, 0, SpringLayout.WEST, score);
        layout.putConstraint(SpringLayout.SOUTH, linesCleared, -10, SpringLayout.NORTH, score);
                        
        layout.putConstraint(SpringLayout.NORTH, quitGame, 5, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, quitGame, -5, SpringLayout.EAST, this);
        
        
        
        //start game here
        
        Random rnd = new Random();
        
        Block current = new Block(rnd.nextInt(7));
        Block next = new Block(rnd.nextInt(7));
        
        
        
        
        
        this.setVisible(true);
        
    }
    @Override
    public String toString()
    {
        return("TETRIS!!!");
    }
}
