import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import de.ovgu.dbse.jswingtexteditor.MainFrame;


public aspect Toolbar {
	private JToolBar	toolBar;
	private MainFrame   mainFrame;
	
	public MainFrame getMainFrame(){
		return this.mainFrame;
	}
	public void addToolBarIcon(String _res, ActionListener _listener) {
		final JButton icon;
		
		icon = new JButton(new ImageIcon(_res));
		toolBar.add(icon);
		toolBar.setFloatable(false);
		icon.addActionListener(_listener);
	}
	pointcut addToolBar(MainFrame m) :  set(* MainFrame.menuPanel) && target(m);
	after(MainFrame m) : addToolBar(m) {
		this.mainFrame = m;
		this.toolBar = new JToolBar();
		m.getMenuPanel().add(toolBar);
	}

	
	final public static pointcut ADD_ICONS(Toolbar t):set(* Toolbar.toolBar) &&this(t);
	
	after(Toolbar t):Toolbar.ADD_ICONS(t){
		addToolBarIcon("res/icon/document-open-8.png",
				t.mainFrame.getOpenFileListner());
	}
}
