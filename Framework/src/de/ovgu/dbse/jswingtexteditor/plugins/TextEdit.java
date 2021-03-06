package de.ovgu.dbse.jswingtexteditor.plugins;

import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

import de.ovgu.dbse.jswingtexteditor.api.TextApi;

public class TextEdit implements TextApi {
	private JTextPane		textView	= new JTextPane();
	private StringBuffer	strB		= new StringBuffer();

	public TextEdit() {
		textView	= new JTextPane();
		strB		= new StringBuffer();
//		textView.setEditable(false);  
//		textView.setCursor(null);  
//		textView.setOpaque(false);  
//		textView.setFocusable(false);
//		textView.setFont(UIManager.getFont("Label.font"));
		
	}
	public void appendLine(String _line) {
		this.strB.append(_line);
		this.strB.append('\n');		
	}

	public void clean() {
		this.strB.setLength(0);
		this.textView.setText(new String());
		
	}

	public JTextPane getPane() {
		return this.textView;
	}

	public int length() {
		return this.strB.length();
	}

	public String substring(int _start, int _end) {
		return this.strB.substring(_start, _end);
	}

	public void show() {
		this.textView.setText(this.strB.toString());		
	}
	public StyledDocument getStyledDocument() {
		return this.textView.getStyledDocument();
	}
	public Style addStyle(String _styleName, Style _parent) {
		return this.textView.addStyle(_styleName, _parent);
	}
	
	public String getContentString() {
		return this.textView.getText();
//		return this.strB.toString();
	}
	
}
