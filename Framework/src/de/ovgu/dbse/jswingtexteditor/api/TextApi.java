package de.ovgu.dbse.jswingtexteditor.api;

import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 * interface for different types of text. e.g.: - only view text, - edit text.
 * 
 * @author Jan
 *
 */
public interface TextApi {
	
	public void appendLine(String _line);
	
	public void clean();
	
	public JTextPane getPane();
	
	public int length();
	
	public String substring(int _start, int _end);
	
	public void show();
	
	public StyledDocument getStyledDocument();
	
	public Style addStyle(String _styleName, Style _parent);
	
	public String getContentString();
}
