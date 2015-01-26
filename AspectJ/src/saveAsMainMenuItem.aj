

public aspect saveAsMainMenuItem {
	after(Menu m):set(* Menu.menuBar) &&this(m) {
		m.addToFileMenu("Save As", saveAs.getSaveAsFileListner(m.getMainFrame()));
	}
}
