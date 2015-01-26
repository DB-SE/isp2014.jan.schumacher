import java.awt.event.ActionListener;

import de.ovgu.dbse.jswingtexteditor.MainFrame;


public aspect saveAs {
	public static ActionListener getSaveAsFileListner(MainFrame m) {
		return e -> save.openSaveFileChooser(m);
	}
	
	declare precedence: *,saveAs,save,Toolbar;
}
