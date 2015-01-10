package de.ovgu.dbse.jswingtexteditor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.ovgu.dbse.jswingtexteditor.menu.*;


/**
 * the frame which is started and has the main content.
 *
 * @author Jan
 *
 */
public class MainFrame extends JFrame {
	public static File	currentFile;
	TextEditView text;

	public MainFrame() {
		
		this.setTitle("TextEditor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		text = new TextEditView();
		initGUI();
	}
	private void initGUI(){
		JScrollPane scrollPane = new JScrollPane(text.getPane());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
