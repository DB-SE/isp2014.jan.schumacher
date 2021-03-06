package de.ovgu.dbse.jswingtexteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
/**
 * a standard menu.
 * @author Jan
 *
 */
public class MainMenu extends JMenuBar {
	public MainMenu(final TextOutput _textOutput) {
		super();
		JMenu mnFile = new JMenu("File");
		this.add(mnFile);

		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(open);
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent et) {
				MainFrame.openFile(MainMenu.this.getComponent(), _textOutput);
			}
		});
	}
}
