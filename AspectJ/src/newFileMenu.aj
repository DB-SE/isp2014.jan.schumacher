
public aspect newFileMenu {
	after(Menu m):set(* Menu.menuBar) &&this(m) {
		m.addToFileMenu("New File", newFile.getNewFileWindow());
	}
}