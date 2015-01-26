import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import de.ovgu.dbse.jswingtexteditor.MainFrame;
import de.ovgu.dbse.jswingtexteditor.TextEditView;


public aspect search {
	JTextField edit;

	after(MainFrame m) : set(* *..MainFrame.text) && this(m) {
		m.getContentPane().add(initSearch(m.getText()), BorderLayout.SOUTH);
	}
	
	private Component initSearch(TextEditView _text) {
		edit = new JTextField();
		edit.getDocument().addDocumentListener(new DocumentListener() {
			
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
				search(edit.getText(), _text);
			}
		});
		return edit;
	}
	private void search(String _query, TextEditView _text) {
		String subString;
		int qLength;
		int tLength;
		StyledDocument doc;
		Style style;

		if(_query.isEmpty()){
			_text.show();
			return;
		}
		qLength = _query.length();
		tLength = _text.length();
		doc     = _text.getStyledDocument();
		style   = _text.addStyle("styleRed", null);

		StyleConstants.setForeground(style, Color.BLACK);
		doc.setCharacterAttributes(0, doc.getLength(), style, true);
		StyleConstants.setForeground(style, Color.red);
		
		for (int i = 0; i + qLength < tLength; i++) {
			subString = _text.substring(i, i + qLength);
			if (subString.equals(_query)) {
				doc.setCharacterAttributes(i, qLength, style, true);
			}
		}
	}
}
