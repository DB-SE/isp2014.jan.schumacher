package de.ovgu.dbse.jswingtexteditor.plugins;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import de.ovgu.dbse.jswingtexteditor.api.MenuApi;
import de.ovgu.dbse.jswingtexteditor.api.TextApi;

public class MainMenu extends MenuApi{


	public MainMenu(TextApi _text, boolean _shortcut, boolean _save) {
		super(_text, _shortcut, _save);
	}

	@Override
	public JComponent getMenuComponent() {
		JMenu mnFile = new JMenu("File");
		final JMenuBar menuBar;
		
		menuBar = new JMenuBar();
		menuBar.add(mnFile);
		
		mnFile.add(addMenuItem("Open", KeyEvent.VK_O, InputEvent.CTRL_MASK,
				getOpenFileListner(menuBar)));
		if (save) {
			mnFile.add(addMenuItem("Save", KeyEvent.VK_S, InputEvent.CTRL_MASK,
					getSaveFileListner()));
			mnFile.add(addMenuItem("Save As...", Integer.MIN_VALUE,
					Integer.MIN_VALUE, getSaveAsFileListner(menuBar)));
		}
		return menuBar;
	}
	
	private JMenuItem addMenuItem(String _name, int _keyCode, int _modifiers,
			ActionListener _actionListener) {
		
		JMenuItem item = new JMenuItem(_name);
		
		if (this.shortcut && _keyCode != Integer.MIN_VALUE
				&& _modifiers != Integer.MIN_VALUE) {
			item.setAccelerator(KeyStroke.getKeyStroke(_keyCode, _modifiers));
		}
		item.addActionListener(_actionListener);
		return item;
	}
	
}
