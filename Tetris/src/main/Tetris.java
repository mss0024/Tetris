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
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import block.*;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Mitch
 */
public class Tetris extends Container implements KeyListener{
    Random rnd = new Random();
    Block current = new Block(rnd.nextInt(7));
    Block next = new Block(rnd.nextInt(7));
    boolean updatePaint = true;
    Image backGroundImage;
    //tetriminos 25x25
    @Override
    public void paint(Graphics g) {
        g.drawImage(backGroundImage, 0, 0, null);
        
        g.fillRoundRect(90,90,270,520,20,20);
        g.fillRoundRect(362,90,125,125,20,20);
        g.setColor(this.getBackground());
        g.fillRect(100,100,250,500);
        g.fillRect(372,100,105,105);
        
        this.paintComponents(g);
    }
    public Tetris(Insets in)
    {
        try{
            backGroundImage = ImageIO.read(new File("images\\main04.jpg"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Fail");
        }
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
        
        
        
        this.setVisible(true);
        
        
        //next.draw(this.getGraphics(), next.getFulcrum(), new Point(530,155));
        
        //start game here
        
        //set action lisners somehwere
        
    }
    
    
    @Override
    public String toString()
    {
        return("TETRIS!!!");
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //37 = left 39 = right
        System.out.println("a;sdfjl");
        if(ke.getKeyCode() == 37){
            current.getPosition().x--;
            System.out.println(this.getGraphics());
            current.draw(current.getFulcrum(), current.getPosition());
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //37 = left 39 = right
        System.out.println("as;df");
         int keyCode = ke.getKeyCode();
            switch( keyCode ) { 
                case KeyEvent.VK_UP:
                    // handle up 
                    break;
                case KeyEvent.VK_DOWN:
                    // handle down 
                    break;
                case KeyEvent.VK_LEFT:
                    current.getPosition().x--;
                    current.draw(current.getFulcrum(), current.getPosition());
                    break;
                case KeyEvent.VK_RIGHT :
                    // handle right
                break;
            }
        
        if(ke.getKeyCode() == 37){
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //37 = left 39 = right
        if(ke.getKeyCode() == 37){
            current.getPosition().x--;
            System.out.println(this.getGraphics());
            current.draw(current.getFulcrum(), current.getPosition());
        }
    }
}
