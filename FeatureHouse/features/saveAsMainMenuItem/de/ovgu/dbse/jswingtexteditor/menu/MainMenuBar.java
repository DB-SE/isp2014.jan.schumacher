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
	private void addToFileMenu(JMenuBar _menuBar){
		original(_menuBar);
		mnFile.add(addMenuItem("Save As...", Integer.MIN_VALUE,
				Integer.MIN_VALUE, getSaveAsFileListner(_menuBar)));
	}
}
