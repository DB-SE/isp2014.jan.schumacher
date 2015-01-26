import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import de.ovgu.dbse.jswingtexteditor.MainFrame;
import de.ovgu.dbse.jswingtexteditor.TextEditView;


public aspect saveAs {
	public static ActionListener getSaveAsFileListner(final Component _root,
			TextEditView _text) {
		ActionListener listner;
		listner = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openSaveFileChooser(_root, _text);
			}
		};
		return listner;
	}
	
	private static void openSaveFileChooser(Component _root, TextEditView _text) {
		File			file;
		JFileChooser	fileChooser;
		int				returnVal;
		
		fileChooser = new JFileChooser();
		returnVal   = fileChooser.showSaveDialog(_root);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				MainFrame.saveFile(file, _text);
		}
	}
	
	
	declare precedence: *,saveAs,save,Toolbar;
}
