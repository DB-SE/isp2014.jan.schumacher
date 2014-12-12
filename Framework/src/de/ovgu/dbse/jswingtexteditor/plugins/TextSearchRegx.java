package de.ovgu.dbse.jswingtexteditor.plugins;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import de.ovgu.dbse.jswingtexteditor.api.SearchApi;
import de.ovgu.dbse.jswingtexteditor.api.TextApi;

public class TextSearchRegx implements SearchApi{

	final JTextField edit;
	private TextApi	text;
	
	public TextSearchRegx() {
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
	public void addText(TextApi _text) {
		this.text = _text;
	}

	public JTextField getComp() {
		return edit;
	}
	
	private void search(String _query) {
		Pattern pattern;
		Matcher matcher;
		StyledDocument doc;
		Style style;
		
		if (_query.isEmpty()) {
			this.text.show();
			return;
		}
		
		try {
			pattern = Pattern.compile(_query);
			matcher = pattern.matcher(text.getContentString());
			doc     = this.text.getStyledDocument();
			
			style = this.text.addStyle("styleRed", null);
			StyleConstants.setForeground(style, Color.BLACK);
			doc.setCharacterAttributes(0, doc.getLength(), style, true);
			StyleConstants.setForeground(style, Color.red);
			while (matcher.find()) {
				doc.setCharacterAttributes(matcher.start(),
						(matcher.end() - matcher.start()), style, true);
			}
		} catch (PatternSyntaxException e) {
			this.text.show();
		}
	}

}
