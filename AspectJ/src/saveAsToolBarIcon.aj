import de.ovgu.dbse.jswingtexteditor.MainFrame;


public aspect saveAsToolBarIcon {
	after(Toolbar t):set(* Toolbar.toolBar) &&this(t)
	{
		MainFrame mFrame;
		
		mFrame = t.getMainFrame();
		t.addToolBarIcon("res/icon/document-save-as-6.png",
				saveAs.getSaveAsFileListner(mFrame, mFrame.getText()));
	}
}
