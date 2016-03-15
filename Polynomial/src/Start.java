import java.awt.Color;

import javax.swing.JFrame;

public class Start{
	public static Userinterface ui;
	 public static void main(String[] args){
	        
	        ui= new Userinterface();
	        Userinterface.userInterface.setSize(1000,100);
	        Userinterface.userInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Userinterface.userInterface.setBackground(Color.black);
	        Userinterface.userInterface.setTitle("Polynomial Calculator");
	        Userinterface.userInterface.setVisible(true);
	        
	    }
}
