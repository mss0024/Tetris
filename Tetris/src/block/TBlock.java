/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

/**
 * Class to represent the T Block in Tetris
 * @author Tyler
 */
public class TBlock extends Block
{
    
    /**
     * No-args Constructor for the T Tetris Block
     * Makes blocks with the below shape
     * 0 0 0 0
     * 0 0 1 0
     * 0 1 1 1
     * 0 0 0 0
     */
    public TBlock()
    {
        fulcrum = new Tetrimino();
        fulcrum.setUp(new Tetrimino());
        fulcrum.setLeft(new Tetrimino());
        fulcrum.setRight(new Tetrimino());
    }
    
}
