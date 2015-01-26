import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import de.ovgu.dbse.jswingtexteditor.MainFrame;
import de.ovgu.dbse.jswingtexteditor.TextEditView;

public aspect save {
	
	declare precedence: *,save,Toolbar;
	public static void MainFrame.saveFile(File _file, TextEditView _text) {
		if (_file == null || _text == null) {
			return;
		}
		try {
			PrintWriter out;
			out = new PrintWriter(_file);
			out.print(_text.getContentString());
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ActionListener getSaveFileListner(MainFrame m) {
		ActionListener listner;
		listner = new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				MainFrame.saveFile(m.getCurrentFile(), m.getText());
			}
		};
		return listner;
	}
}
