

public aspect dbWinMenu {
	// TODO Auto-generated aspect
	after(Menu m):set(* Menu.menuBar) &&this(m) {
		m.addToFileMenu("duplicate", dbWin.getNewWindow(m.getMainFrame()));
	}
}