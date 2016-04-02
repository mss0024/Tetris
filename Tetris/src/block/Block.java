/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

import java.awt.Color;
import java.awt.Point;
import main.Grid;
/**
 *
 * @author Tyler
 */
public class Block implements TBProperties
{
    protected Tetrimino fulcrum = null;
    private static Grid grid;
    
    public Block(int color, int shape){
        
        switch(shape){
            case 0: // S-Block
                fulcrum = new Tetrimino(colorList[color]);
                fulcrum.setRight(new Tetrimino(colorList[color]));
                fulcrum.setDown(new Tetrimino(colorList[color]));
                fulcrum.getDown()
                        .setLeft(new Tetrimino(colorList[color]));
                break;
            case 1: // L-Block
                fulcrum = new Tetrimino(colorList[color]);
                fulcrum.setRight(new Tetrimino(colorList[color]));
                fulcrum.setLeft(new Tetrimino(colorList[color]));
                fulcrum.getLeft()
                        .setDown(new Tetrimino(colorList[color]));
                break;
            case 2: // O-Block
                fulcrum = new Tetrimino(colorList[color]);
                fulcrum.setLeft(new Tetrimino(colorList[color]));
                fulcrum.setDown(new Tetrimino(colorList[color]));
                fulcrum.getDown()
                        .setLeft(new Tetrimino(colorList[color]));
                break;
            case 3: // T-Block
                fulcrum = new Tetrimino(colorList[color]);
                fulcrum.setLeft(new Tetrimino(colorList[color]));
                fulcrum.setRight(new Tetrimino(colorList[color]));
                fulcrum.setDown(new Tetrimino(colorList[color]));
                break;
            case 4: // Z-Block
                fulcrum = new Tetrimino(colorList[color]);
                fulcrum.setLeft(new Tetrimino(colorList[color]));
                fulcrum.setDown(new Tetrimino(colorList[color]));
                fulcrum.getDown()
                        .setRight(new Tetrimino(colorList[color]));
                break;
            case 5: // J-Block
                fulcrum = new Tetrimino(colorList[color]);
                fulcrum.setLeft(new Tetrimino(colorList[color]));
                fulcrum.setRight(new Tetrimino(colorList[color]));
                fulcrum.getRight()
                        .setDown(new Tetrimino(colorList[color]));
                break;
            case 6: // I-Block
                fulcrum = new Tetrimino(colorList[color]);
                fulcrum.setRight(new Tetrimino(colorList[color]));
                fulcrum.setLeft(new Tetrimino(colorList[color]));
                fulcrum.getLeft()
                        .setLeft(new Tetrimino(colorList[color]));
                break;
        }
        
    }
    
    /**
    
    
    
    /**
     * Rotates the block 90 degrees in a clockwise direction.
     * @param rotationFulcrum The Tetrimino that is currently having 
     *                        it's outer connecting Tetriminos rotated
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
    
    /**
     * Function to loop through the block placement
     */
    public void update(){
        
    }
    
    /**
     * Function to draw the block on the GUI
     */
    public void draw(){
        
    }
    
    /**
     * Check to make sure that the Tetrimino is still in the grid
     * @param t the tetrimino we are checking 
     * @return true if still in grid, false otherwise
     */
    public boolean boundCheck(Tetrimino t){
        return true;
    }
    
    /**
     * Check to see if the tetrimino will collide with another tetrimino
     * @param t
     * @return 
     */
    public boolean collisionCheck(Tetrimino t){
        
        return false;
    }
    
    /**
     * Move the tetrimino left, right, or down
     * @param t     tetrimino we are moving
     * @param dir   direction that we are moving (0: left, 1: right, 2: down)
     */
    public void movePiece(Tetrimino t, int dir){
        
    }
    
    /**
     * Move the tetrimino straight down until there is a collision
     * @param t     tetrimino we are moving
     */
    public void dropPiece(Tetrimino t){
        
    }
    
    
    
    
    
    
    public static void main(String [] args){
        
              
        
        
    }
    
}