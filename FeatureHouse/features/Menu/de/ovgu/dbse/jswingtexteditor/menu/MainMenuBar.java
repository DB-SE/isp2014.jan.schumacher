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
	JMenu mnFile = new JMenu("File");

	public MainMenuBar(TextEditView _text) {
		super(_text);
	}

	@Override
	public JComponent getMenuComponent() {
		final JMenuBar menuBar;
		
		menuBar = new JMenuBar();
		menuBar.add(mnFile);
		
		addToFileMenu(menuBar);
		return menuBar;
	}
	private void addToFileMenu(JMenuBar _menuBar){
		mnFile.add(addMenuItem("Open", KeyEvent.VK_O, InputEvent.CTRL_MASK,
				getOpenFileListner(_menuBar)));
	}
	private JMenuItem addMenuItem(String _name, int _keyCode, int _modifiers,
			ActionListener _actionListener) {
		
		JMenuItem item = new JMenuItem(_name);
		item.addActionListener(_actionListener);
		return item;
	}
	
}
