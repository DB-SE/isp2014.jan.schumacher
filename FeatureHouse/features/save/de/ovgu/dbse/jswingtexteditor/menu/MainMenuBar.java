package de.ovgu.dbse.jswingtexteditor.menu;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import de.ovgu.dbse.jswingtexteditor.menu.MenuApi;

/**
 * TODO description
 */
public class MainMenuBar extends MenuApi{
	private void addToFileMenu(JMenuBar _menuBar){
		original(_menuBar);
		mnFile.add(addMenuItem("Save", KeyEvent.VK_S, InputEvent.CTRL_MASK,
				getSaveFileListner()));
	}
}