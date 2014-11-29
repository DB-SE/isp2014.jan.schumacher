package de.ovgu.dbse.jswingtexteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
/**
 * a toolbar for some menu entries.
 * @author Jan
 *
 */
public class ToolbarMenu extends JToolBar {
	public ToolbarMenu(final TextView _textOutput) {
		super();
		final JButton openFile;
		
		openFile = new JButton(new ImageIcon("res/icon/document-open-8.png"));
        this.add(openFile);
        this.setFloatable(false);
        openFile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent et) {
				MainFrame.openFile(getComponent(0), _textOutput);
			}
		});
	}
}
