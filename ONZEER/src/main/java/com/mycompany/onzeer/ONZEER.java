package com.mycompany.onzeer; // ONZEER main package

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Application main class
 * @author Simon MILLET
 */
public class ONZEER
{
    /**
     * Default ONZEER constructor
     */
    public ONZEER(){}
    
    /**
     * Application main function
     * @param args The common java command line arguments
     */
    public static void main(String [] args)
    {
        // Sets up FlatLaf dark theme
        FlatDarkLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        // Creates main graphic window
        Window window = new Window("Onzeer");

        // Sets up application window size
        window.setSize(900, 600);

        // Makes the main window visible
        window.setVisible(true);
    }
}
