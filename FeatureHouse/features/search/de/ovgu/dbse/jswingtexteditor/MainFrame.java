package de.ovgu.dbse.jswingtexteditor;

import de.ovgu.dbse.jswingtexteditor.search.*;

public class MainFrame extends JFrame {
	
	private void initGUI() {
		original();
		TextSearch search;
		
		search = new TextSearch();
		search.addText(this.text);
		getContentPane().add(search.getComp(), BorderLayout.SOUTH);
	}
}
