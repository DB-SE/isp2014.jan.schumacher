import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.ovgu.dbse.jswingtexteditor.MainFrame;

public aspect Menu {
	private MainFrame	mainFrame;
	private JMenu		mnFile;
	private JMenuBar	menuBar;
	
	
	after(MainFrame m) : 	 set(* MainFrame.menuPanel) && target(m) {
		this.mainFrame = m;
		mnFile = new JMenu("File");
		
		menuBar = new JMenuBar();
		menuBar.add(mnFile);
		
		// if (save) {
		// mnFile.add(addMenuItem("Save", KeyEvent.VK_S, InputEvent.CTRL_MASK,
		// getSaveFileListner()));
		// mnFile.add(addMenuItem("Save As...", Integer.MIN_VALUE,
		// Integer.MIN_VALUE, getSaveAsFileListner(menuBar)));
		// }
		m.getMenuPanel().add(menuBar,0);
	}
	
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}

	public JMenuBar getMenuBar() {
		return this.menuBar;
	}

	after():set(* Menu.menuBar) {
		addToFileMenu("Open", mainFrame.getOpenFileListner());
	}
	
	public void addToFileMenu(String _name, ActionListener _actionListener) {
		mnFile.add(addMenuItem(_name, _actionListener));
	}
	
	private JMenuItem addMenuItem(String _name, ActionListener _actionListener) {
		
		JMenuItem item = new JMenuItem(_name);
		item.addActionListener(_actionListener);
		return item;
	}
}
