package de.ovgu.dbse.jswingtexteditor.search;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import de.ovgu.dbse.jswingtexteditor.TextEditView;

public class TextSearch{

	final JTextField edit;
	private TextEditView	text;
	
	public TextSearch() {
		edit = new JTextField();
		edit.getDocument().addDocumentListener( new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				change();
			}
			
			public void insertUpdate(DocumentEvent e) {
				change();
			}
			public void changedUpdate(DocumentEvent e) {
				change();
			}
			
			private void change() {
				search(edit.getText());
			}
		});
	}
	public void addText(TextEditView _text) {
		this.text = _text;
	}

	public JTextField getComp() {
		return edit;
	}
	
	private void search(String _query) {
		String subString;
		int qLength;
		int tLength;
		StyledDocument doc;
		Style style;

		if(_query.isEmpty()){
			text.show();
			return;
		}
		qLength = _query.length();
		tLength = text.length();
		doc     = text.getStyledDocument();
		style   = text.addStyle("styleRed", null);

		StyleConstants.setForeground(style, Color.BLACK);
		doc.setCharacterAttributes(0, doc.getLength(), style, true);
		StyleConstants.setForeground(style, Color.red);
		
		for (int i = 0; i + qLength < tLength; i++) {
			subString = text.substring(i, i + qLength);
			if (subString.equals(_query)) {
				doc.setCharacterAttributes(i, qLength, style, true);
			}
		}
	}

	
}
