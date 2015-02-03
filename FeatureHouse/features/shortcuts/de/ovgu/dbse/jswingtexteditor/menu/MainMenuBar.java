package de.ovgu.dbse.jswingtexteditor.menu;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import de.ovgu.dbse.jswingtexteditor.menu.MenuApi;
import de.ovgu.dbse.jswingtexteditor.TextEditView;

public class MainMenuBar extends MenuApi{

	private JMenuItem addMenuItem(String _name, int _keyCode, int _modifiers,
			ActionListener _actionListener) {
		
		JMenuItem item = original(_name, _keyCode, _modifiers, _actionListener);
		
		if (_keyCode != Integer.MIN_VALUE
				&& _modifiers != Integer.MIN_VALUE) {
			item.setAccelerator(KeyStroke.getKeyStroke(_keyCode, _modifiers));
		}
		return item;
	}
	
}
