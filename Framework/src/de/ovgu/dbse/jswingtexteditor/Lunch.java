package de.ovgu.dbse.jswingtexteditor;

import javax.swing.SwingUtilities;

/**
 * start the application.
 * 
 * @author Jan
 *
 */
public class Lunch {
	public static void main(final String... _args){
		Runnable	guiCreator;
		guiCreator = new Runnable() {

			public void run() {
				MainFrame	mainFrame;
				
				mainFrame = new MainFrame();
				mainFrame.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(guiCreator);
	}
}
