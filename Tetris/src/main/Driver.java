/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.SpringLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



/**
 *
 * @author Mitch
 */
public class Driver{
    static Image backGroundImage;
    private static void createAndShowGUI(){
        try{
            Driver.backGroundImage = ImageIO.read(Driver.class.getResource("/images/logo01.jpg"));
        }
        catch(Exception e){
        }
        //creating the window
        //Making a new JFrame and setting the title bar to "Tetris!"
        JFrame frame = new JFrame("Tetris!");
        //setting the action for when the user presses the X in the to right and setting it as closing the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setIconImage(backGroundImage);
        
        //creating the pane
        //getting the contentPane already in the JFrame
        JLabel backGround = new JLabel();
        backGround.setIcon(new ImageIcon(Driver.class.getResource("/images/main04.jpg")));
        
        frame.setContentPane(backGround);
        
        Container contentPane = frame.getContentPane();
        //making a new springLayout
        SpringLayout layout = new SpringLayout();
        //setting the layout to the SpringLayout
        contentPane.setLayout(layout);
        frame.setSize(new Dimension(515,700));
        Insets frameInsets = frame.getInsets();
        int paneHeight = frame.getHeight() - frameInsets.top - frameInsets.bottom;
        int paneWidth = frame.getWidth() - frameInsets.left - frameInsets.right;
        contentPane.setSize(paneHeight, paneWidth);
        //all the buttons that will be on screen
        JButton startTetris = new JButton();
        JButton openOptions = new JButton();
        JButton quitGame = new JButton();
        int buttonWidth = 150;
        int buttonHeight = 30;
        
        startTetris.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        openOptions.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        quitGame.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        
        quitGame.setIcon(new ImageIcon(Driver.class.getResource("/images/Exit01.jpg")));
        startTetris.setIcon(new ImageIcon(Driver.class.getResource("/images/Start01.jpg")));
        openOptions.setIcon(new ImageIcon(Driver.class.getResource("/images/Options01.jpg")));
        //setting action listeners
        
        startTetris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                contentPane.setVisible(false);
                //frame.getContentPane().removeAll();
                frame.setContentPane(new Tetris(frameInsets, frame, contentPane));
                //frame.validate();
            }
        });
        openOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                //make options and shit here
            }
        });
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                Object[] options = {"Yes","No",};
                int n = JOptionPane.showOptionDialog(frame, "Are you sure?", "Quit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (n == 0){//yes back to menu
                    System.exit(0);
                }
            }
        });
        
        
        //putting stuff on the pane and positioning
        contentPane.add(startTetris);
        //contentPane.add(openOptions);
        contentPane.add(quitGame);
        
        
        ArrayList<JButton> menuButtons = new ArrayList();
        menuButtons.add(startTetris);
        //menuButtons.add(openOptions);
        menuButtons.add(quitGame);
        //this statement basically says we are going to put the west(left) side of the startTetris object
        // 100 pixels away from the west(left) side of the contentPane
        layout.putConstraint(SpringLayout.WEST, menuButtons.get(0), contentPane.getHeight()/2 - buttonWidth/2, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, menuButtons.get(0), contentPane.getWidth()/2 - ((3*buttonHeight)+(10*2))/2, SpringLayout.NORTH, contentPane);
        for(int i=1;i<menuButtons.size();i++) {
            layout.putConstraint(SpringLayout.WEST, menuButtons.get(i), 0, SpringLayout.WEST, menuButtons.get(0));
            layout.putConstraint(SpringLayout.NORTH, menuButtons.get(i), 10, SpringLayout.SOUTH, menuButtons.get(i-1));
        }
        
        
        //get set the frame size in relation to the components in it
        //frame.pack();
        //saying which frame is currently visible
        frame.setVisible(true);
   }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public Driver() {
        
    }
    
}
