import de.ovgu.dbse.jswingtexteditor.MainFrame;


public aspect saveAsMainMenuItem {
	after(Menu m):set(* Menu.menuBar) &&this(m) {
		MainFrame mFrame;
		
		mFrame = m.getMainFrame();
		m.addToFileMenu("Save As",
				saveAs.getSaveAsFileListner(mFrame, mFrame.getText()));
	}
}
