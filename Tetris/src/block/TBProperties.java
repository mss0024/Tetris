
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

import java.awt.Color;
/**
 * This is an interface for a few variables that should be shared across
 * the various Tetris classes
 * Includes three variables for the color of a tetrimino, the direction a 
 * tetrimino should go, and the shape of the tetris block
 * @author Tyler
 */
public interface TBProperties {
        
    // array for the Colors of the Tetriminos
    public static final Color[] colorList=
    {
     new Color(255, 99, 71), //Tomato Red  S-Block
     new Color(255, 215, 0), //GOLD        L-Block
     new Color(173, 255, 47), //GREEN_YELLOW O-Block
     new Color(32, 178, 170), //SEA_GREEN  T-Block
     new Color(30, 144, 255), //SKY_BLUE   Z-Block
     new Color(106, 90, 205), //SLATE_BLUE J-Block
     new Color(255, 192, 203) //PINK       I-Block
    };  
    
    // enum for the shape of the Block
    public enum Shape {S, L, O, T, Z, J, I};
    
    // enum for the direction a Tetrimino should go
    public enum Direction {UP, DOWN, LEFT, RIGHT};
    
}
