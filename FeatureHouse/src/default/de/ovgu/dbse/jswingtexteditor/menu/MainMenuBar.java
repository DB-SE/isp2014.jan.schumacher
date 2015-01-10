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

public   class  MainMenuBar  extends MenuApi {
	
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

	
	 private void  addToFileMenu__wrappee__Menu  (JMenuBar _menuBar){
		mnFile.add(addMenuItem("Open", KeyEvent.VK_O, InputEvent.CTRL_MASK,
				getOpenFileListner(_menuBar)));
	}

	
	 private void  addToFileMenu__wrappee__saveMainMenuItem  (JMenuBar _menuBar){
		addToFileMenu__wrappee__Menu(_menuBar);
		mnFile.add(addMenuItem("Save", KeyEvent.VK_S, InputEvent.CTRL_MASK,
				getSaveFileListner()));
	}

	
	private void addToFileMenu(JMenuBar _menuBar){
		addToFileMenu__wrappee__saveMainMenuItem(_menuBar);
		mnFile.add(addMenuItem("Save As...", Integer.MIN_VALUE,
				Integer.MIN_VALUE, getSaveAsFileListner(_menuBar)));
	}

	
	 private JMenuItem  addMenuItem__wrappee__Menu  (String _name, int _keyCode, int _modifiers,
			ActionListener _actionListener) {
		
		JMenuItem item = new JMenuItem(_name);
		item.addActionListener(_actionListener);
		return item;
	}

	

	private JMenuItem addMenuItem(String _name, int _keyCode, int _modifiers,
			ActionListener _actionListener) {
		
		JMenuItem item = addMenuItem__wrappee__Menu(_name, _keyCode, _modifiers, _actionListener);
		
		if (_keyCode != Integer.MIN_VALUE
				&& _modifiers != Integer.MIN_VALUE) {
			item.setAccelerator(KeyStroke.getKeyStroke(_keyCode, _modifiers));
		}
		return item;
	}


}
