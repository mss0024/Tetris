/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import block.Tetrimino;
import java.util.ArrayList;

/**
 * This is the table we use for the Tetris game board
 * Holds the Tetriminos
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

    /** Accessor
     * @return return madness
     */
    public ArrayList<ArrayList<Tetrimino>> getGrid(){
        return grid;
    }
    
    /**
     * Initializes initial grid values to null (no tetriminos)
     * @param grid  2-D Tetrimino Array List we are initializing 
     */
    private static void initializeGrid(ArrayList<ArrayList<Tetrimino>> grid){
        for (int i = 0; i < 22; i++){
            ArrayList<Tetrimino> oneRow = new ArrayList<>();
            grid.add(i, oneRow);

            for (int columnNum = 0; columnNum != 10; columnNum++) {
                oneRow.add(columnNum, null);
            }
        }    
    }
        
    /**
     * Check to see if the rows of the grid are full
     * If a row is full, then we will call the clearRow function
     * @param grid  2-D Tetrimino Array List we are searching
     */
    public static int checkIfRowFull(ArrayList<ArrayList<Tetrimino>> grid){
        int i = 0;
        for (int rowNum = 2; rowNum < 22; rowNum++){
            ArrayList<Tetrimino> oneRow = grid.get(rowNum);
            for(int colNum = 0; colNum < 10; colNum++){
                if(oneRow.get(colNum) == null)
                    break;
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
    
    public void draw(){
        for (int i = 0; i < 22; i++){
            for (int j = 0; j != 10; j++) {
                if(grid.get(i).get(j)!= null)
                    grid.get(i).get(j).draw(100+(25*j), 50+(25*i));
            }
        } 
    }
    
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
