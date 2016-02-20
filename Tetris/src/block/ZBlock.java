/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

/**
 * Class to represent the Z Block in Tetris
 * @author Tyler
 */
public class ZBlock extends Block
{

    /**
     * No-args Constructor for the Z Tetris Block
     * Makes blocks with the below shape
     * 0 0 0 0
     * 0 1 1 0
     * 0 0 1 1
     * 0 0 0 0
     */
    public ZBlock()
    {
        fulcrum = new Tetrimino();
        fulcrum.setLeft(new Tetrimino());
        fulcrum.setDown(new Tetrimino());
        fulcrum.getDown().setRight(new Tetrimino());
    }
    
}
