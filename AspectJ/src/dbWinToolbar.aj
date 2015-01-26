public aspect dbWinToolbar {
	
	after(Toolbar t):set(* Toolbar.toolBar) &&this(t){
		t.addToolBarIcon("res/icon/edit-copy-3.png",
				dbWin.getNewWindow(t.getMainFrame()));
	}
}
