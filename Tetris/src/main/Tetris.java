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
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 *
 * @author Mitch
 */
public class Tetris extends Container{
    //image for the background
    Image backGroundImage;
    //random seed for generating blocks
    Random rnd = new Random();
    //the spring layout
    SpringLayout layout = new SpringLayout();
    //the current block initialized to a random block
    Block current = new Block(rnd.nextInt(7), this, layout);
    //the next block initialized to a random block
    Block next = new Block(rnd.nextInt(7), this, layout);
    //tetriminos 25x25
    /**
     * Java paint method that is called at some point after object initialized.
     * @param g Graphics object that is being painted on
     */
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
        //paint all of the buttons and labels ect.
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
        //get the current keyboard manager.
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        //add our dispacher to the manager
        manager.addKeyEventDispatcher(new MyDispatcher());
        
        //set the size of our window
        this.setPreferredSize(new Dimension(700-in.left-in.right,700-in.top-in.bottom));
        //set the layout to the spring layout
        this.setLayout(layout);
        //make or components
        JButton quitGame = new JButton("Exit");
        JLabel score = new JLabel("Score: 0");
        JLabel linesCleared = new JLabel("Lines Cleared: 0");
        //add them to the pane
        this.add(quitGame);
        this.add(linesCleared);
        this.add(score);
        //put constraints on our components
        layout.putConstraint(SpringLayout.NORTH, score, 600, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, score, 370, SpringLayout.WEST, this);
        
        layout.putConstraint(SpringLayout.WEST, linesCleared, 0, SpringLayout.WEST, score);
        layout.putConstraint(SpringLayout.SOUTH, linesCleared, -10, SpringLayout.NORTH, score);
                        
        layout.putConstraint(SpringLayout.NORTH, quitGame, 5, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, quitGame, -5, SpringLayout.EAST, this);
        //draw the tetris pecies
        next.draw(next.getFulcrum(), new Point(13,2));
        current.draw(current.getFulcrum(), new Point(5,0));
        
        //add action listener to the quit button(currently does something dumb)
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                layout.removeLayoutComponent(quitGame);
                Tetris.this.remove(quitGame);
                Tetris.this.add(quitGame);
                layout.putConstraint(SpringLayout.NORTH, quitGame, 5, SpringLayout.NORTH, Tetris.this);
                layout.putConstraint(SpringLayout.WEST, quitGame, 5, SpringLayout.WEST, Tetris.this);
                revalidate();
                repaint();
            }
        });
        
        this.setVisible(true);
        
        
        //next.draw(this.getGraphics(), next.getFulcrum(), new Point(530,155));
        
        //start game here
        
        //set action lisners somehwere
        
    }
    
    
    //does something to get all keyboard input idk what a keyeventdispacter is
    class MyDispatcher implements KeyEventDispatcher{
        /**
         * Gets keyboard input and acts off of it.
         * @param e The key that was pressed
         * @return 
         */
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            //when a key is pressed down
            if (e.getID() == KeyEvent.KEY_PRESSED) {
            } 
            //when a key is released
            else if (e.getID() == KeyEvent.KEY_RELEASED) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){//left
                    //move the piece to the left
                    current.movePiece(current.getFulcrum(),0);
                    //redraw the piece
                    current.draw(current.getFulcrum(), current.getPosition());
                    //redraw everything
                    revalidate();
                    repaint();
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){//right
                    current.movePiece(current.getFulcrum(), 1);
                    current.draw(current.getFulcrum(), current.getPosition());
                    revalidate();
                    repaint();
                    
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){//up
                    current.rotate(current.getFulcrum());
                    current.draw(current.getFulcrum(), current.getPosition());
                    revalidate();
                    repaint();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){//down
                    current.movePiece(current.getFulcrum(), 2);
                    current.draw(current.getFulcrum(), current.getPosition());
                    revalidate();
                    repaint();
                }
            }
            //when a key is pressed and released.  Only of character input for some ungodly reason
            else if (e.getID() == KeyEvent.KEY_TYPED) {
            }
            //???
            return false;
        }  
   } 

}
