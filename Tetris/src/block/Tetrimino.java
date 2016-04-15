/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

/**
 * This class is the Base Tetrimino that makes up all Tetris blocks
 * 
 * @author Tyler
 * @author Mitch
 */
public class Tetrimino implements TBProperties
{

    
    private Tetrimino left = null;      // Tetrimino to the left
    private Tetrimino right = null;     // Tetrimino to the right
    private Tetrimino up = null;        // Tetrimino above
    private Tetrimino down = null;      // Tetrimino below
    private Color color = null;         // Color of Tetrimino 
    private final int width = 25;
    private final int height = 25;
    private JLabel label = null;
    private final SpringLayout layout;
    private final Container pane;
    

    public Tetrimino(Color newColor, Container c, SpringLayout l){
        //put the correct image with the color
        if(newColor == colorList[0]){
            color = colorList[0];
            label = new JLabel(new ImageIcon(Tetrimino.class.getResource("/images/T06.jpg")));
        }
        if(newColor == colorList[1]){
            color = colorList[1];
            label = new JLabel(new ImageIcon(Tetrimino.class.getResource("/images/T01.jpg")));
        }
        if(newColor == colorList[2]){
            color = colorList[2];
            label = new JLabel(new ImageIcon(Tetrimino.class.getResource("/images/T04.jpg")));
        }
        if(newColor == colorList[3]){
            color = colorList[3];
            label = new JLabel(new ImageIcon(Tetrimino.class.getResource("/images/T07.jpg")));
        }
        if(newColor == colorList[4]){
            color = colorList[4];
            label = new JLabel(new ImageIcon(Tetrimino.class.getResource("/images/T04.jpg")));
        }
        if(newColor == colorList[5]){
            color = colorList[5];
            label = new JLabel(new ImageIcon(Tetrimino.class.getResource("/images/T02.jpg")));
        }
        if(newColor == colorList[6]){
            color = colorList[6];
            label = new JLabel(new ImageIcon(Tetrimino.class.getResource("/images/T03.jpg")));
        }
        c.add(label);
        layout = l;
        pane = c;
    }
    
    public Color getColor(){
        return color;
    }
    /**
     * Gets the Tetrimino to the left of this
     * @return The left Tetrimino
     */
    public Tetrimino getLeft()
    {
        return left;
    }
    /**
     * Gets the Tetrimino to the right of this
     * @return The right Tetrimino
     */
    public Tetrimino getRight()
    {
        return right;
    }
    /**
     * Gets the Tetrimino to above of this
     * @return The Tetrimino above
     */
    public Tetrimino getUp()
    {
        return up;
    }
    /**
     * Gets the Tetrimino
     * @return The Tetrimino below
     */
    public Tetrimino getDown()
    {
        return down;
    }
    /**
     * Sets the Tetrimino to the left of this
     * @param newLeft The Tetrimino to be set to left
     */
    public void setLeft(Tetrimino newLeft)
    {
        left = newLeft;
    }
    /**
     * Sets the Tetrimino to the Right of this
     * @param newRight The Tetrimino to be set to right
     */
    public void setRight(Tetrimino newRight)
    {
        right = newRight;
    }
    /**
     * Sets the Tetrimino above this
     * @param newUp The Tetrimino to be set to up
     */
    public void setUp(Tetrimino newUp)
    {
        up = newUp;
    }
    /**
     * Sets the Tetrimino below of this
     * @param newDown The Tetrimino to be set to down
     */
    public void setDown(Tetrimino newDown)
    {
        down = newDown;
    }
    
    /**
     * Function to draw the individual Tetrimino
     * Not sure what to do with this yet...
     * @param x
     * @param y
     */
    public void draw(int x, int y){
        
        //remove previous constraints
        layout.removeLayoutComponent(label);
        //remove it form the pane
        pane.remove(label);
        //re-add it to the pane
        pane.add(label);       
        //put new constraints on
        layout.putConstraint(SpringLayout.WEST, label, x, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, label, y, SpringLayout.NORTH, pane);
    }

    
}

