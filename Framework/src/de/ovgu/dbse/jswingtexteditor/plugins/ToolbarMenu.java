package de.ovgu.dbse.jswingtexteditor.plugins;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;

import de.ovgu.dbse.jswingtexteditor.api.MenuApi;
import de.ovgu.dbse.jswingtexteditor.api.TextApi;

public class ToolbarMenu extends MenuApi {

	public ToolbarMenu(TextApi _text, boolean _shortcut, boolean _save) {
		super(_text, _shortcut, _save);
	}
	
	@Override
	public JComponent getMenuComponent() {
		final JToolBar toolBar;
		
		toolBar = new JToolBar();
		addIcon(toolBar, "res/icon/document-open-8.png",
				getOpenFileListner(toolBar));
		if (save) {
			addIcon(toolBar, "res/icon/document-save-7.png",
					getSaveFileListner());
			addIcon(toolBar, "res/icon/document-save-as-6.png",
					getSaveAsFileListner(toolBar));
		}
		return toolBar;
	}
	
	private void addIcon(JToolBar _toolBar,String _res, ActionListener _listener){
		final JButton  icon;

		icon = new JButton(new ImageIcon(_res));
        _toolBar.add(icon);
        _toolBar.setFloatable(false);
		icon.addActionListener(_listener);
	}

}
