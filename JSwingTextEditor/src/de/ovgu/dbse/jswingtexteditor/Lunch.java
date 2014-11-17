package de.ovgu.dbse.jswingtexteditor;

import javax.swing.SwingUtilities;

/**
 * start the application.
 * @author Jan
 *
 */
public class Lunch {
	public static void main(final String... _args){
		Runnable	guiCreator;
		guiCreator = new Runnable() {


			@Override
			public void run() {
				boolean		menu    = false;
				boolean		toolbar = false;
				MainFrame	mainFrame;
				
				for(String s: _args){
					if(s.equals("Menu")) {
						menu = true;
					}
					if(s.equals("Toolbar")) {
						toolbar = true;
					}
				}

				mainFrame = new MainFrame(menu, toolbar, false);
				mainFrame.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(guiCreator);
	}
}
