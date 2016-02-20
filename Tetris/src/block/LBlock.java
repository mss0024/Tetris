/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

/**
 * Class to represent the L Block in Tetris
 * @author Tyler
 */
public class LBlock extends Block
{
    
    /**
     * No-args Constructor for the L Tetris Block
     * Makes blocks with the below shape
     * 0 0 0 0
     * 0 0 0 1
     * 0 1 1 1
     * 0 0 0 0
     */
    public LBlock()
    {
        fulcrum = new Tetrimino();
        fulcrum.setLeft(new Tetrimino());
        fulcrum.setRight(new Tetrimino());
        fulcrum.getRight().setUp(new Tetrimino());
    }

    
}
