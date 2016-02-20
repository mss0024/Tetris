/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

import java.awt.Color;

/**
 * This class is the Base Tetrimino that makes up all Tetris blocks
 * 
 * @author Tyler
 */
public class Tetrimino extends Block
{

    private Tetrimino left = null;      // Tetrimino to the left
    private Tetrimino right = null;     // Tetrimino to the right
    private Tetrimino up = null;        // Tetrimino above
    private Tetrimino down = null;      // Tetrimino below
    private Color color = null;         // Color of Tetrimino 
    
    public Tetrimino(){
        
    }
    
}
