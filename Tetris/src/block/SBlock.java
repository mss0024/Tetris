/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

/**
 * Class to represent the S Block in Tetris
 * @author Tyler
 */
public class SBlock extends Block
{
    
    /**
     * No-Args Constructor for the S Tetris Block
     * Makes a block with the below shape
     * 0 0 0 0
     * 0 0 1 1
     * 0 1 1 0
     * 0 0 0 0
     */
    public SBlock()
    {
        fulcrum = new Tetrimino();
        fulcrum.setRight(new Tetrimino());
        fulcrum.setDown(new Tetrimino());
        fulcrum.getDown().setLeft(new Tetrimino());
    }
    
}
