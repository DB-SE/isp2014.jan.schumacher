
public aspect saveToolBarIcon {
	after(Toolbar t):set(* Toolbar.toolBar) &&this(t)
	{
		t.addToolBarIcon("res/icon/document-save-3.png",
				save.getSaveFileListner(t.getMainFrame()));
	}
}
