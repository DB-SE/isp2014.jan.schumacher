import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import de.ovgu.dbse.jswingtexteditor.MainFrame;

public aspect core {
	public static ActionListener getOpenFileListner(MainFrame m) {
		return e -> {
			JFileChooser fileChooser;
			int returnVal;
			
			fileChooser = new JFileChooser();
			returnVal = fileChooser.showOpenDialog(m);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				m.setCurrentFile(fileChooser.getSelectedFile());
				m.loadCurrentFile();
			}
		};
	}
}
