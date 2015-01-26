import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import de.ovgu.dbse.jswingtexteditor.MainFrame;

public aspect core {
	public ActionListener MainFrame.getOpenFileListner() {
		ActionListener listner;
		listner = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		};
		return listner;
	}
	public void MainFrame.openFile() {
		JFileChooser fileChooser;
		int returnVal;

		fileChooser = new JFileChooser();
		returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.setCurrentFile(fileChooser.getSelectedFile());
			this.loadCurrentFile();
		}
	}
}
