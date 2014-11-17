package de.ovgu.dbse.jswingtexteditor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
/**
 * the frame which is started and has the main content.
 * @author Jan
 *
 */
public class MainFrame extends JFrame {
	public MainFrame(boolean _menu, boolean _toolbar, boolean _edit) {
		TextOutput textOutput;

		this.setTitle("TextEditor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		//		if(_edit){
		//			textOutput =
		//		}
		//		else{
		textOutput = new TextView();
		textOutput.appendLine("test");
		//		}
		this.getContentPane().add((Component) textOutput, BorderLayout.CENTER);
		if(_menu){
			JMenuBar menuBar = new MainMenu(textOutput);
			panel.add(menuBar);
		}
		if(_toolbar){
			JToolBar toolBar = new ToolbarMenu(textOutput);
			panel.add(toolBar);
		}
	}
	
	public static void openFile(Component _root,TextOutput _out) {
		File			file;
		JFileChooser	fileChooser;
		BufferedReader	br;
		int				returnVal;
		String			line;
		
		fileChooser = new JFileChooser();
		returnVal   = fileChooser.showOpenDialog(_root);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				file = fileChooser.getSelectedFile();
				br   = new BufferedReader(new FileReader(file));
				_out.clean();
				while((line = br.readLine())!= null){
					_out.appendLine(line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
