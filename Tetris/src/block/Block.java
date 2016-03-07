/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

import java.awt.Color;
import java.awt.Point;
/**
 *
 * @author Tyler
 */
public class Block 
{
    protected Tetrimino fulcrum = null;
    protected static final Color[] COLORS = 
    {new Color(255, 99, 71),    // Tomato Red
     new Color(255, 215, 0),    // Gold
     new Color(173, 255, 47),   // Green-Yellow
     new Color(32, 178, 170),   // Light Sea Green
     new Color(30, 144, 255),   // Deep Sky Blue
     new Color(106, 90, 205),   // Slate Blue
     new Color(255, 192, 203)}; // Pink
    Point location;
    enum TetrisPiece {}
    /**
     * Rotates the block 90 degrees in a clockwise direction.
     * @param rotationFulcrum The Tetrimino that is currently having it's outer connecting Tetriminos rotated
     */
    public void rotate(Tetrimino rotationFulcrum)
    {
        Tetrimino temp = rotationFulcrum.getUp();           //setting temp to store a tet
        rotationFulcrum.setUp(rotationFulcrum.getLeft());   //moving the blocks clockwise
        rotationFulcrum.setLeft(rotationFulcrum.getDown());
        rotationFulcrum.setDown(rotationFulcrum.getRight());
        rotationFulcrum.setRight(temp);
        if(rotationFulcrum.getUp()!= null)  //checking if there is a another block
            rotate(rotationFulcrum.getUp());//to be rotated and if there is rotating it
        if(rotationFulcrum.getLeft()!= null)
            rotate(rotationFulcrum.getLeft());
        if(rotationFulcrum.getDown()!= null)
            rotate(rotationFulcrum.getDown());
        if(rotationFulcrum.getRight()!= null)
            rotate(rotationFulcrum.getRight());
        
    }
}