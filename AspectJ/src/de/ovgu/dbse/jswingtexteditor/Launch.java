package de.ovgu.dbse.jswingtexteditor; 

import javax.swing.SwingUtilities; 

/**
 * start the application.
 * 
 * @author Jan
 *
 */
public  class  Launch {
	
	public static void main(final String... _args){
		SwingUtilities.invokeLater(() -> {
			MainFrame mainFrame;
			
			mainFrame = new MainFrame();
			mainFrame.setVisible(true);
		});
	}


}
