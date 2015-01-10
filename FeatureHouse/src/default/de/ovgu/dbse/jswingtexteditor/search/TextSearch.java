package de.ovgu.dbse.jswingtexteditor.search; 

import java.awt.Color; 

import javax.swing.JTextField; 
import javax.swing.event.DocumentEvent; 
import javax.swing.event.DocumentListener; 
import javax.swing.text.Style; 
import javax.swing.text.StyleConstants; 
import javax.swing.text.StyledDocument; 

import de.ovgu.dbse.jswingtexteditor.TextEditView; import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import java.util.regex.PatternSyntaxException; 

public   class  TextSearch {
	

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

	
	private void search  (String _query) {
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
