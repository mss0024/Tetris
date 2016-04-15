/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;


import java.awt.Container;
import java.awt.Point;
import javax.swing.SpringLayout;
import main.Grid;
import main.Tetris;
/**
 *
 * @author Tyler
 * @author Mitch
 */
public class Block implements TBProperties
{
    protected Tetrimino fulcrum = null;
    private String whatShape;
    private static Grid grid = new Grid();
    private Point position = null;
    private Container pane = null;
    private SpringLayout lay = null;
    
    public Block(int shape, Container c, SpringLayout layout){
        pane = c;
        lay = layout;
        position = new Point(5, 0);
        switch(shape){
            case 0: // S-Block
                fulcrum = new Tetrimino(colorList[0], c, layout);
                fulcrum.setRight(new Tetrimino(colorList[0], c, layout));
                fulcrum.setDown(new Tetrimino(colorList[0], c, layout));
                fulcrum.getDown()
                        .setLeft(new Tetrimino(colorList[0], c, layout));
                whatShape = "S";
                break;
            case 1: // L-Block
                fulcrum = new Tetrimino(colorList[1], c, layout);
                fulcrum.setRight(new Tetrimino(colorList[1], c, layout));
                fulcrum.setLeft(new Tetrimino(colorList[1], c, layout));
                fulcrum.getLeft()
                        .setDown(new Tetrimino(colorList[1], c, layout));
                whatShape = "L";
                break;
            case 2: // O-Block
                fulcrum = new Tetrimino(colorList[2], c, layout);
                fulcrum.setLeft(new Tetrimino(colorList[2], c, layout));
                fulcrum.setDown(new Tetrimino(colorList[2], c, layout));
                fulcrum.getDown()
                        .setLeft(new Tetrimino(colorList[2], c, layout));
                whatShape = "O";
                break;
            case 3: // T-Block
                fulcrum = new Tetrimino(colorList[3], c, layout);
                fulcrum.setLeft(new Tetrimino(colorList[3], c, layout));
                fulcrum.setRight(new Tetrimino(colorList[3], c, layout));
                fulcrum.setDown(new Tetrimino(colorList[3], c, layout));
                whatShape = "T";
                break;
            case 4: // Z-Block
                fulcrum = new Tetrimino(colorList[4], c, layout);
                fulcrum.setLeft(new Tetrimino(colorList[4], c, layout));
                fulcrum.setDown(new Tetrimino(colorList[4], c, layout));
                fulcrum.getDown()
                        .setRight(new Tetrimino(colorList[4], c, layout));
                whatShape = "Z";
                break;
            case 5: // J-Block
                fulcrum = new Tetrimino(colorList[5], c, layout);
                fulcrum.setLeft(new Tetrimino(colorList[5], c, layout));
                fulcrum.setRight(new Tetrimino(colorList[5], c, layout));
                fulcrum.getRight()
                        .setDown(new Tetrimino(colorList[5], c, layout));
                whatShape = "J";
                break;
            case 6: // I-Block
                fulcrum = new Tetrimino(colorList[6], c, layout);
                fulcrum.setRight(new Tetrimino(colorList[6], c, layout));
                fulcrum.setLeft(new Tetrimino(colorList[6], c, layout));
                fulcrum.getLeft()
                        .setLeft(new Tetrimino(colorList[6], c, layout));
                whatShape = "I";
                break;
        }
        
    }
    
    
    
    public void rotateHelper(Block b){
        Block temp = b.clone();
        rotate(temp.getFulcrum());
        if(boundCheck(temp.getFulcrum(),temp.getPosition()) && collisionCheck(temp.getFulcrum(),temp.getPosition()))
            rotate(b.getFulcrum());
    }
    
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
     * Function that calls the Tetriminos draw functions
     * @param p The current position of the Tetrimino to draw
     * @param drawFulcrum The current tetrimino to draw
     */
    public void draw(Tetrimino drawFulcrum, Point p){
        //draw the current tetrimino and then call the rest
        drawFulcrum.draw( 100+(25*p.x), 50+(25*p.y));
        if(drawFulcrum.getUp() != null)
            draw(drawFulcrum.getUp(),new Point(p.x,p.y-1));
        if(drawFulcrum.getLeft() != null)
            draw(drawFulcrum.getLeft(),new Point(p.x-1,p.y));
        if(drawFulcrum.getDown() != null)
            draw(drawFulcrum.getDown(),new Point(p.x,p.y+1));
        if(drawFulcrum.getRight() != null)
            draw(drawFulcrum.getRight(),new Point(p.x+1,p.y));
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
        if(p.y > 21)
            return false;
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
    public boolean movePiece(Tetrimino t, int dir){
        switch (dir){
            
            //Move left
            case 0:
                if(collisionCheck(t, new Point(position.x-1, position.y)) && 
                        boundCheck(t, new Point(position.x-1, position.y)))
                    --position.x;

                break;
            //Move right
            case 1:
                if(collisionCheck(t, new Point(position.x+1, position.y)) && 
                        boundCheck(t, new Point(position.x+1, position.y)))
                    ++position.x;
                   
                break;
            //Move down    
            case 2:
                if(collisionCheck(t, new Point(position.x, position.y+1)) && 
                        boundCheck(t, new Point(position.x, position.y+1)))
                    ++position.y;
                else
                {
                    placeTetriminos(fulcrum, position);
                    int temp = Grid.checkIfRowFull(grid.getGrid());
                        Tetris tTemp = ((Tetris)pane);
                    if(temp == 1){
                        tTemp.numLines = tTemp.numLines + 1;
                        tTemp.numScore = tTemp.numScore + 10;
                    }
                    if(temp == 2){
                        tTemp.numLines = tTemp.numLines + 2;
                        tTemp.numScore = tTemp.numScore + 25;
                    }
                    if(temp == 3){
                        tTemp.numLines = tTemp.numLines + 3;
                        tTemp.numScore = tTemp.numScore + 50;
                    }
                    if(temp == 4){
                        tTemp.numLines = tTemp.numLines + 4;
                        tTemp.numScore = tTemp.numScore + 100;
                    }
                    tTemp.score.setText("Score: " + tTemp.numScore);
                    tTemp.linesCleared.setText("Lines Clread: " + tTemp.numLines);
                    grid.toString();
                    grid.draw();
                    return true;
                }
                break;               
        }
        return false;
    }
    
    private void placeTetriminos(Tetrimino placeFulcrum, Point p){
        grid.getGrid().get(p.y).set(p.x, placeFulcrum);
        if(placeFulcrum.getUp() != null)
            placeTetriminos(placeFulcrum.getUp(), new Point(p.x,p.y-1));
        if(placeFulcrum.getLeft() != null)
            placeTetriminos(placeFulcrum.getLeft(), new Point(p.x-1,p.y));
        if(placeFulcrum.getDown() != null)
            placeTetriminos(placeFulcrum.getDown(), new Point(p.x,p.y+1));
        if(placeFulcrum.getRight() != null)
            placeTetriminos(placeFulcrum.getRight(), new Point(p.x+1,p.y));
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
    public Point getPosition(){
        return position;
    }
    
    public Tetrimino getFulcrum(){
        return fulcrum;
    }
    private void setFulcrum(Tetrimino newFulcrum){
        fulcrum = newFulcrum;
    }
    
    private void setPosition(Point p){
        position = p;
    }
    @Override
    public String toString(){
        return whatShape + "";
    }
    
    public Tetrimino cloneTetrimino(Tetrimino cloneFulcrum){
        Tetrimino temp = cloneFulcrum.clone();
        if(cloneFulcrum.getUp() != null)
            temp.setUp(cloneTetrimino(cloneFulcrum.getUp()));
        if(cloneFulcrum.getLeft() != null)
            temp.setLeft(cloneTetrimino(cloneFulcrum.getLeft()));
        if(cloneFulcrum.getDown() != null)
            temp.setDown(cloneTetrimino(cloneFulcrum.getDown()));
        if(cloneFulcrum.getRight() != null)
            temp.setRight(cloneTetrimino(cloneFulcrum.getRight()));
        return temp;
    }
    
    public boolean gameOver(){
        return grid.isGameOver();
    }
    
    @Override
    public Block clone(){
        Block temp = new Block(0,pane,lay);
        temp.setFulcrum(cloneTetrimino(fulcrum));
        temp.setPosition(position);
        return temp;
    }

    
}