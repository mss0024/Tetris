/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import block.Tetrimino;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Tyler
 */
public class Grid {
    
ArrayList<ArrayList<Tetrimino>> grid = null;

public Grid(){
    grid = new ArrayList<>();
    initializeGrid(grid);
}

private static void initializeGrid(ArrayList<ArrayList<Tetrimino>> grid){
    for (int i = 0; i < 20; i++){
        ArrayList<Tetrimino> oneRow = new ArrayList<>();
        grid.add(i, oneRow);
        
        for (int columnNum = 0; columnNum != 10; columnNum++) {
            oneRow.add(columnNum, null);
        }
    }    
}

private static void printTable(ArrayList<ArrayList<Tetrimino>> grid) {
        for (int row = 0; row != 10; row++) {
            for (int col = 0; col != 10; col++) {
                System.out.println("Printing:               row= "+ row+ ", column= "+ col);
                System.out.println(grid.get(row).get(col));
            }
        }
        System.out.println("\n");
    }

public static void main(String[] args){
    Grid g = new Grid();
    Grid.printTable(g.grid);
}

}
