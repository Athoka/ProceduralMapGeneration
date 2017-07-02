package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import graphics.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		 try {
	            // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
		VentanaPrincipal window = new VentanaPrincipal();
		window.setVisible(true);
	}

}
