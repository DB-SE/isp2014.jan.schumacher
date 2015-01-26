import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import de.ovgu.dbse.jswingtexteditor.MainFrame;


public aspect control {
	private JPanel MainFrame.menuPanel;
	
	public JPanel MainFrame.getMenuPanel(){
		return this.menuPanel;
	}
	public void MainFrame.setMenuPanel(JPanel panel){
		this.menuPanel = panel;
	}
	
	
	after(MainFrame m) : call(* ..TextEditView.new()) && this(m) {
		m.setMenuPanel(new JPanel());
		m.getMenuPanel().setLayout(new GridLayout(0, 1, 0, 0));
		m.getContentPane().add(m.getMenuPanel(), BorderLayout.NORTH);
	}
	
}
