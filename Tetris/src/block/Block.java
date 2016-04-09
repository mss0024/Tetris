/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;


import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import main.Grid;
/**
 *
 * @author Tyler
 */
public class Block implements TBProperties
{
    protected Tetrimino fulcrum = null;
    private String whatShape;
    private static Grid grid;
    Point position = null;
    
    public Block(int shape){
        
        position = new Point(0, 5);
        switch(shape){
            case 0: // S-Block
                fulcrum = new Tetrimino(colorList[0]);
                fulcrum.setRight(new Tetrimino(colorList[0]));
                fulcrum.setDown(new Tetrimino(colorList[0]));
                fulcrum.getDown()
                        .setLeft(new Tetrimino(colorList[0]));
                whatShape = "S";
                break;
            case 1: // L-Block
                fulcrum = new Tetrimino(colorList[1]);
                fulcrum.setRight(new Tetrimino(colorList[1]));
                fulcrum.setLeft(new Tetrimino(colorList[1]));
                fulcrum.getLeft()
                        .setDown(new Tetrimino(colorList[1]));
                whatShape = "L";
                break;
            case 2: // O-Block
                fulcrum = new Tetrimino(colorList[2]);
                fulcrum.setLeft(new Tetrimino(colorList[2]));
                fulcrum.setDown(new Tetrimino(colorList[2]));
                fulcrum.getDown()
                        .setLeft(new Tetrimino(colorList[2]));
                whatShape = "O";
                break;
            case 3: // T-Block
                fulcrum = new Tetrimino(colorList[3]);
                fulcrum.setLeft(new Tetrimino(colorList[3]));
                fulcrum.setRight(new Tetrimino(colorList[3]));
                fulcrum.setDown(new Tetrimino(colorList[3]));
                whatShape = "T";
                break;
            case 4: // Z-Block
                fulcrum = new Tetrimino(colorList[4]);
                fulcrum.setLeft(new Tetrimino(colorList[4]));
                fulcrum.setDown(new Tetrimino(colorList[4]));
                fulcrum.getDown()
                        .setRight(new Tetrimino(colorList[4]));
                whatShape = "Z";
                break;
            case 5: // J-Block
                fulcrum = new Tetrimino(colorList[5]);
                fulcrum.setLeft(new Tetrimino(colorList[5]));
                fulcrum.setRight(new Tetrimino(colorList[5]));
                fulcrum.getRight()
                        .setDown(new Tetrimino(colorList[5]));
                whatShape = "J";
                break;
            case 6: // I-Block
                fulcrum = new Tetrimino(colorList[6]);
                fulcrum.setRight(new Tetrimino(colorList[6]));
                fulcrum.setLeft(new Tetrimino(colorList[6]));
                fulcrum.getLeft()
                        .setLeft(new Tetrimino(colorList[6]));
                whatShape = "I";
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
        // MAKE A COPY OF THE BLASCK AND PASS IT OT THIS METHOD TO CHECK AND THEN
        // IF IT IS VALID THEN CALL IT AGASIN ON THE ORIGINAL BLCOK
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
        
        //loop to go through block placement
        
            //thread sleep for x seconds
            //to allow user to move left or right or down
            //if the user wants to move left or right, run a collision and
            //bounds check recursively first
            
            //after thread is done sleeping, check for a collision downwards
            //if no collision, move block downwards and resume loop
            //if there is a collision, end the block movement and the loop,
            //get new
        
        
        
        
    }
    
    /**
     * Function to draw the block on the GUI
     */
    public void draw(Graphics g, Tetrimino fulcrum, int x, int y){
        fulcrum.draw(g, x, y, fulcrum.getColor());
        if(fulcrum.getUp() != null)
            draw(g,fulcrum.getUp(),x,y-25);
        if(fulcrum.getLeft() != null)
            draw(g,fulcrum.getLeft(),x-25,y);
        if(fulcrum.getDown() != null)
            draw(g,fulcrum.getDown(),x,y+25);
        if(fulcrum.getRight() != null)
            draw(g,fulcrum.getRight(),x+25,y);
    }
    
    /**
     * Check to make sure that the Tetrimino is still in the grid
     * @param t the tetrimino we are checking
     * @param p the position point on the grid for the tetrimino we are checking
     * @return true if still in grid, false otherwise
     */
    public boolean boundCheck(Tetrimino t, Point p){
        boolean b = true;
        if (p.x < 0 || p.x > 9)
            return false;
        if (p.y > 21)
            return false;
        if(t.getUp() != null && !boundCheck(t.getUp(),new Point(p.x,p.y-1)))
            b = false;
        if(t.getRight() != null && !boundCheck(t.getRight(), new Point(p.x + 1, p.y)))
            b = false;
        if(t.getLeft() != null && !boundCheck(t.getLeft(), new Point(p.x - 1, p.y)))
            b = false;
        if(t.getDown() != null && !boundCheck(t.getDown(), new Point(p.x, p.y + 1)))
            b = false;
        
        return b;
    }
    
    /**
     * Check to see if the tetrimino will collide with another tetrimino
     * @param t    Tetrimino we are checking for pre-existing tetriminos in grid
     * @param p    Point we are looking at in the grid  
     * @return 
     * 
     */
    public boolean collisionCheck(Tetrimino t, Point p){
        boolean b = true;
        if (grid.getGrid().get(p.y).get(p.x) != null)
            return false;
        if (t.getUp() != null && !collisionCheck(t.getUp(), new Point(p.x, p.y - 1)))
            b = false;
        if (t.getLeft() != null && !collisionCheck(t.getLeft(), new Point(p.x - 1, p.y)))
            b = false;
        if (t.getRight() != null && !collisionCheck(t.getRight(), new Point(p.x + 1, p.y)))
            b = false;
        if (t.getDown() != null && !collisionCheck(t.getDown(), new Point(p.x, p.y + 1)))
            b = false;
        return b;
    }
    
    /**
     * Move the tetrimino left, right, or down
     * @param t     tetrimino we are moving
     * @param dir   direction that we are moving (0: left, 1: right, 2: down)
     */
    public void movePiece(Tetrimino t, int dir){
        switch (dir){
            
            //Move left
            case 0:
                if(collisionCheck(t, new Point(--position.x, position.y)) && 
                        boundCheck(t, new Point(--position.x, position.y)))
                    --position.x;

                break;
            //Move right
            case 1:
                if(collisionCheck(t, new Point(++position.x, position.y)) && 
                        boundCheck(t, new Point(++position.x, position.y)))
                    ++position.x;
                   
                break;
            //Move down    
            case 2:
                if(collisionCheck(t, new Point(position.x, ++position.y)) && 
                        boundCheck(t, new Point(position.x, ++position.y)))
                    ++position.y;
 
                break;               
        }
    }
    
    /**
     * Move the tetrimino straight down until there is a collision
     * @param t     tetrimino we are moving
     */
    public void dropPiece(Tetrimino t){
        while(collisionCheck(t, new Point(position.x, ++position.y))){
            movePiece(t, 2);
        }
        
        //call place piece on grid
        
    }
    
    public static void main(String [] args){
        
              
        
        
    }
    
    @Override
    public String toString(){
        return whatShape;
    }
    
}