import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import de.ovgu.dbse.jswingtexteditor.MainFrame;

public aspect newFile {
	public static ActionListener getNewFileWindow() {
		return e -> SwingUtilities.invokeLater(() -> {
			MainFrame mainFrame;
			mainFrame = new MainFrame();
			mainFrame.setVisible(true);
		});
	}
}