import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingUtilities;

import de.ovgu.dbse.jswingtexteditor.MainFrame;


public aspect dbWin {
	public static ActionListener getNewWindow(MainFrame m) {
		return e -> {
			SwingUtilities.invokeLater(() -> {
				MainFrame mainFrame;
				File file = m.getCurrentFile();
				mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				if (file != null && file.exists()) {
					mainFrame.setCurrentFile(file);
					mainFrame.loadCurrentFile();
				}
			});
		};
	}
}