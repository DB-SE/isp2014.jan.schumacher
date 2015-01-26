package de.ovgu.dbse.jswingtexteditor; 

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public   class  MainFrame  extends JFrame {
	
	private File	currentFile;

	
	private TextEditView text;

	

	public MainFrame() {
		
		this.setTitle("TextEditor");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 300);
		
		text = new TextEditView();
		JScrollPane scrollPane = new JScrollPane(text.getPane());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}



	public TextEditView getText() {
		return text;
	}
	public void loadCurrentFile(){
		BufferedReader br;
		String line;
		
		try {
			br   = new BufferedReader(new FileReader(this.currentFile));
			getText().clean();
			while ((line = br.readLine()) != null) {
				getText().appendLine(line);
			}
			getText().show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public File getCurrentFile() {
		return currentFile;
	}



	public void setCurrentFile(File currentFile) {
		this.currentFile = currentFile;
	}
}
