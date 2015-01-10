package de.ovgu.dbse.jswingtexteditor.menu;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;

import de.ovgu.dbse.jswingtexteditor.TextEditView;

public class ToolbarMenu extends MenuApi {

	public ToolbarMenu(TextEditView _text) {
		super(_text);
	}
	
	@Override
	public JComponent getMenuComponent() {
		final JToolBar toolBar;
		
		toolBar = new JToolBar();
		this.addIcons(toolBar);
		return toolBar;
	}
	private void addIcons(JToolBar toolBar){
		addIcon(toolBar, "res/icon/document-open-8.png",
				getOpenFileListner(toolBar));
	}
	private void addIcon(JToolBar _toolBar,String _res, ActionListener _listener){
		final JButton  icon;

		icon = new JButton(new ImageIcon(_res));
        _toolBar.add(icon);
        _toolBar.setFloatable(false);
		icon.addActionListener(_listener);
	}

}
