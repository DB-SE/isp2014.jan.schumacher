
public aspect saveMainMenuItem {
	after(Menu m):set(* Menu.menuBar) &&this(m) {
		m.addToFileMenu("Save", save.getSaveFileListner(m.getMainFrame()));
	}
}
