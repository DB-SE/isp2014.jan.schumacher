

public aspect saveAsToolBarIcon {
	after(Toolbar t):set(* Toolbar.toolBar) &&this(t)
	{
		t.addToolBarIcon("res/icon/document-save-as-3.png",
				saveAs.getSaveAsFileListner(t.getMainFrame()));
	}
}
