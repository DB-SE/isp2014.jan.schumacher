import java.awt.Insets;
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
		icon.setMargin(new Insets ( 0, 0, 0, 0 ) );
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

	
	
	after():set(* Toolbar.toolBar){
		addToolBarIcon("res/icon/document-open-3.png",
				core.getOpenFileListner(this.mainFrame));
	}
}
