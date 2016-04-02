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
        
        
        
        
        
        
        
        
        
        this.setVisible(true);
        
    }
    @Override
    public String toString()
    {
        return("TETRIS!!!");
    }
}
