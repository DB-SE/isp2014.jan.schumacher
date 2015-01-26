public aspect newFileToolbar {
	after(Toolbar t):set(* Toolbar.toolBar) &&this(t){
		t.addToolBarIcon("res/icon/document-new-3.png",
				newFile.getNewFileWindow());
	}
}