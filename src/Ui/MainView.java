package Ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * <b>MainView is the frame of the software.</b>
 * <p>
 * The MainView allows the software to get a frame to display information on.
 * </p>
 * 
 * 
 * @author Giordani
 * @version 1.0
*/
public class MainView extends JFrame{
	
	/** The screen size. */
	private	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/** The width. */
	private	int width = (int)(screenSize.getWidth()* 0.75);
	
	/** The height. */
	private	int height = (int)(screenSize.getHeight()* 0.75);
	
	/**
		 * Constructor MainView.
		 * <p>
		 * The Mainview constructor is initializing the frame, and automatically displays a menu.
		 * </p>
		 * 
	 */
	public MainView(){
		new JFrame();
		this.setTitle("Execute");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize((int)(width),(int)(height));
		this.setVisible(true);
		this.setResizable(false);		
		this.setLayout(null);
        this.setVisible(true);
        changePanel(new Menu(this));
	}

	/**
		 * Change Panel.
		 * <p>
		 * Change the current panel to the panel given in argument.
		 * </p>
		 * @param panel
		 *            The new panel that will be displayed.
	 */
	public void changePanel(JPanel panel){
		this.setContentPane(panel);
		setVisible(true);	
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		new MainView();
	}
	
}
