/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import block.Tetrimino;
import java.util.ArrayList;

/**
 * Grid is the table we use for the Tetris game board.
 * Holds the Tetriminos, allows for us to do row manipulations.
 * @author Tyler
 */
public class Grid {

    // the grid as a 2-D ArrayList
    private ArrayList<ArrayList<Tetrimino>> grid = null;

    /**
     * No-args constructor for the Grid class
     */
    public Grid(){
        grid = new ArrayList<>();
        initializeGrid(grid);
    }

    /** Accessor method for the grid variable
     * @return the 2-D ArrayList grid
     */
    public ArrayList<ArrayList<Tetrimino>> getGrid(){
        return grid;
    }
    
    /**
     * Initializes initial grid values to null (no tetriminos).
     * @param grid  2-D Tetrimino Array List we are initializing 
     */
    private static void initializeGrid(ArrayList<ArrayList<Tetrimino>> grid){
        // 22 rows
        for (int i = 0; i < 22; i++){
            ArrayList<Tetrimino> oneRow = new ArrayList<>();
            grid.add(i, oneRow);
            
            // 10 columns
            for (int columnNum = 0; columnNum != 10; columnNum++) {
                oneRow.add(columnNum, null);
            }
        }    
    }
        
    /**
     * Check to see if the rows of the grid are full.
     * If a row is full, then we will call the clearRow function
     * @param grid  2-D Tetrimino Array List we are searching
     */
    public static int checkIfRowFull(ArrayList<ArrayList<Tetrimino>> grid){
        int i = 0;
        
        // Check the bottom 20 rows
        for (int rowNum = 2; rowNum < 22; rowNum++){
            ArrayList<Tetrimino> oneRow = grid.get(rowNum);
            
            // Check the 10 columns
            for(int colNum = 0; colNum < 10; colNum++){
                
                // Row not full
                if(oneRow.get(colNum) == null)
                    break;
                
                // Row is full
                if(colNum == 9 && oneRow.get(colNum) != null){
                    clearRow(rowNum, grid);
                    ++i;
                }
            }
        }
        return i;
    }

    /**
     * Clears the given row of the ArrayList and adds a replacement row to the top
     * Exclusively called by the checkIfRowFull method
     * @param rowNum    row Number of the grid we are deleting
     * @param grid      grid we are deleting and adding to
     */
    private static void clearRow(int rowNum, ArrayList<ArrayList<Tetrimino>> grid){
        for(Tetrimino t : grid.get(rowNum)){
            t.destructor();
        }
        grid.remove(rowNum);
        ArrayList<Tetrimino> oneRow = new ArrayList<>();
        for(int colNum = 0; colNum < 10; colNum++){
            oneRow.add(colNum, null);
        }
        grid.add(0, oneRow);
    }
    
    /**
     * Calls the draw method from Tetrimino on each space for the grid.
     */
    public void draw(){
        for (int i = 0; i < 22; i++){
            for (int j = 0; j != 10; j++) {
                // Draws the Tetrimino if it exists
                if(grid.get(i).get(j) != null)
                    grid.get(i).get(j).draw(100+(25*j), 50+(25*i));
            }
        } 
    }
    
    /**
     * Method used for checking if the game has reached terminal state.
     * Returns true if a Tetrimino occupies a space in the first two rows, false otherwise.
     * @return 
     */
    public boolean isGameOver(){
        for(int i=0; i<2; i++){
            for(Tetrimino t : grid.get(i)){
                if(t != null)
                    return true;
            }
        }
        return false;
    }
    
    
    @Override
    /**
     * Method used for debugging.
     * Prints out a matrix of 1's for tetriminos, 0's for null
     */
    public String toString(){
        for(ArrayList<Tetrimino> a : grid){
            for(Tetrimino t : a){
                if(t!= null)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        return "";
    }
}
