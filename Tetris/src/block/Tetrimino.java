/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class is the Base Tetrimino that makes up all Tetris blocks
 * 
 * @author Tyler
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
    JLabel label;
    

    public Tetrimino(Color newColor){
        if(color == colorList[1])
        {
            
        }
        color = newColor;
        label = new JLabel(new ImageIcon(Tetrimino.class.getResource("/images/T01.jpg")));
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
       label.setLocation(x,y);
    }

    
}

