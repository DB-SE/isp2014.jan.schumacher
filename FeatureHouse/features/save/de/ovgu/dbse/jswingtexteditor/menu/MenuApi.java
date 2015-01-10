package de.ovgu.dbse.jswingtexteditor.menu;

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
import de.ovgu.dbse.jswingtexteditor.TextEditView;

public abstract class MenuApi {

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
		MainFrame.saveFile(_file, text);
	}
}
