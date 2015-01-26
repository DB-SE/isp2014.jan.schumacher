import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingUtilities;

import de.ovgu.dbse.jswingtexteditor.MainFrame;


public aspect dbWin {
	// TODO Auto-generated aspect
	public static ActionListener getNewWindow(MainFrame m){
		 return new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Runnable	guiCreator;
					guiCreator = new Runnable() {

						public void run() {
							MainFrame	mainFrame;
							File file = m.getCurrentFile();
							mainFrame = new MainFrame();
							mainFrame.setVisible(true);
							if (file != null && file.exists()) {
								mainFrame.setCurrentFile(file);
								mainFrame.loadCurrentFile();
							}
						}
					};
					SwingUtilities.invokeLater(guiCreator);				
				}
			};
	}
}