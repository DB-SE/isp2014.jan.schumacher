package de.ovgu.dbse.jswingtexteditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import de.ovgu.dbse.jswingtexteditor.TextEditView;

public class MainFrame extends JFrame {
	public static  void saveFile(File _file, TextEditView _text){
		if(_file == null || _text == null){
			return;
		}
		try {
			PrintWriter out;
			out = new PrintWriter(_file);
			out.print(_text.getContentString());
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
