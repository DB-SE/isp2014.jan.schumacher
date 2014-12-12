package de.ovgu.dbse.jswingtexteditor.api;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JComponent;
import javax.swing.JFileChooser;

import de.ovgu.dbse.jswingtexteditor.MainFrame;

public abstract class MenuApi {
	protected boolean	shortcut;
	protected boolean	save;
	protected TextApi   text;
	
	public MenuApi(TextApi _text, boolean _shortcut,boolean _save) {
		this.shortcut = _shortcut;
		this.save     = _save;
		this.text     = _text;
	}
	public abstract JComponent getMenuComponent();
	
	protected ActionListener getOpenFileListner(final Component _root) {
		ActionListener listner;
		listner = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openFile(_root);
			}
		};
		return listner;
	}
	
	private void openFile(Component _root) {
		JFileChooser fileChooser;
		BufferedReader br;
		int returnVal;
		String line;

		fileChooser = new JFileChooser();
		returnVal = fileChooser.showOpenDialog(_root);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				MainFrame.currentFile = fileChooser.getSelectedFile();
				br   = new BufferedReader(new FileReader(MainFrame.currentFile));
				this.text.clean();
				while ((line = br.readLine()) != null) {
					this.text.appendLine(line);
				}
				this.text.show();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected ActionListener getSaveAsFileListner(final Component _root) {
		ActionListener listner;
		listner = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openSaveFileChooser(_root);
			}
		};
		return listner;
	}
	
	protected ActionListener getSaveFileListner() {
		ActionListener listner;
		listner = new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				saveFile(MainFrame.currentFile);
			}
		};
		return listner;
	}	
	private void openSaveFileChooser(Component _root) {
		File			file;
		JFileChooser	fileChooser;
		int				returnVal;
		
		fileChooser = new JFileChooser();
		returnVal   = fileChooser.showSaveDialog(_root);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				saveFile(file);
		}
	}
	private void saveFile(File _file){
		if(_file == null){
			return;
		}
		try {
			PrintWriter out;
			out = new PrintWriter(_file);
			out.print(text.getContentString());
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
