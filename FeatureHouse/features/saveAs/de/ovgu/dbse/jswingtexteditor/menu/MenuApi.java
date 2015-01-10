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
	protected ActionListener getSaveAsFileListner(final Component _root) {
		ActionListener listner;
		listner = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openSaveFileChooser(_root);
			}
		};
		return listner;
	}
}
