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
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
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
public class Tetris extends Container{
    
    boolean updatePaint = true;
    Image backGroundImage;
    Random rnd = new Random();
    SpringLayout layout = new SpringLayout();
    Block current = new Block(rnd.nextInt(7), this, layout);
    //Block next = new Block(rnd.nextInt(7), this, layout);
    //tetriminos 25x25
    @Override
    public void paint(Graphics g) {
        //g.drawImage(backGroundImage, 0, 0, null);
        //draw the outer rectangles
        g.fillRoundRect(90,90,270,520,20,20);
        g.fillRoundRect(362,90,125,125,20,20);
        g.setColor(this.getBackground());
        //draw the inner rectangels
        g.fillRect(100,100,250,500);
        g.fillRect(372,100,105,105);
        this.paintComponents(g);
        
    }
    public Tetris(Insets in)
    {
        /*
        try{
            backGroundImage = ImageIO.read(new File("images\\main04.jpg"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Fail");
        }
        */
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        this.setPreferredSize(new Dimension(700-in.left-in.right,700-in.top-in.bottom));
        this.setLayout(layout);
        
        JButton quitGame = new JButton("Exit");
        JLabel score = new JLabel("Score: 0");
        JLabel linesCleared = new JLabel("Lines Cleared: 0");
                
        this.add(quitGame);
        this.add(linesCleared);
        this.add(score);
        layout.putConstraint(SpringLayout.NORTH, score, 600, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, score, 370, SpringLayout.WEST, this);
        
        layout.putConstraint(SpringLayout.WEST, linesCleared, 0, SpringLayout.WEST, score);
        layout.putConstraint(SpringLayout.SOUTH, linesCleared, -10, SpringLayout.NORTH, score);
                        
        layout.putConstraint(SpringLayout.NORTH, quitGame, 5, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, quitGame, -5, SpringLayout.EAST, this);
        
        //next.draw(next.getFulcrum(), new Point(13,2));
        current.draw(current.getFulcrum(), new Point(5,0));
        
        this.setVisible(true);
        
        
        //next.draw(this.getGraphics(), next.getFulcrum(), new Point(530,155));
        
        //start game here
        
        //set action lisners somehwere
        
    }
    
    
    
    class MyDispatcher implements KeyEventDispatcher{
       @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
            } 
            else if (e.getID() == KeyEvent.KEY_RELEASED) {
                System.out.print(e.getKeyChar());
                System.out.println(" ," + e.getKeyCode());
                if(e.getKeyCode() == KeyEvent.VK_LEFT){//left
                    System.out.println("Left");
                    current.movePiece(current.getFulcrum(),0);
                    current.draw(current.getFulcrum(), current.getPosition());
                    Tetris.this.repaint();
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){//right
                    current.movePiece(current.getFulcrum(),1);
                    current.draw(current.getFulcrum(), current.getPosition());
                    
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){//up
                    
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){//down
                    
                }
            } 
            else if (e.getID() == KeyEvent.KEY_TYPED) {
            }
            return false;
        }  
   } 

}
