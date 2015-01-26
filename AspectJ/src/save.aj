import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import de.ovgu.dbse.jswingtexteditor.MainFrame;

public aspect save {
	
	declare	precedence: *,save,Toolbar;
	
	public static void saveFile(MainFrame m) {
		if (m.getCurrentFile() == null) {
			System.out.println("file not found");
			openSaveFileChooser(m);
			return;
		}
		if (m.getText() == null) {
			System.out.println("text not found");
			return;
		}
		try {
			PrintWriter out;
			out = new PrintWriter(m.getCurrentFile());
			out.print(m.getText().getContentString());
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ActionListener getSaveFileListner(MainFrame m) {
		return e -> saveFile(m);
	}
	protected static void openSaveFileChooser(MainFrame m) {
		File			file;
		JFileChooser	fileChooser;
		int				returnVal;
		
		fileChooser = new JFileChooser();
		returnVal   = fileChooser.showSaveDialog(m);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			if (file != null) {
				m.setCurrentFile(file);
				saveFile(m);
			}
		}
	}
}
