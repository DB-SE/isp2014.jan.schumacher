package de.ovgu.dbse.jswingtexteditor;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * only show text.
 *
 * @author Jan
 *
 */
public class TextView extends JTextPane {
	StringBuilder	strB	= new StringBuilder();

	public TextView() {
		super();
		setEditable(false);  
        setCursor(null);  
        setOpaque(false);  
        setFocusable(false);
        setFont(UIManager.getFont("Label.font"));      
	}
	public void appendLine(String _line) {
		this.strB.append(_line);
		this.strB.append('\n');

	}
	public void show(){
		this.setText(this.strB.toString());
	}
	public void clean() {
		this.strB.setLength(0);
		this.setText(new String());
	}
	//#ifdef search
	public void search(String _query) {
		String subString;
		int qLength;
		int tLength;
		StyledDocument doc;
		Style style;

		if(_query.isEmpty()){
			this.show();
			return;
		}
		qLength = _query.length();
		tLength = this.strB.length();
		doc     = this.getStyledDocument();
		style   = this.addStyle("styleRed", null);

		StyleConstants.setForeground(style, Color.BLACK);
		doc.setCharacterAttributes(0, doc.getLength(), style, true);
		StyleConstants.setForeground(style, Color.red);
		
		for (int i = 0; i + qLength < tLength; i++) {
			subString = this.strB.substring(i, i + qLength);
			if (subString.equals(_query)) {
				doc.setCharacterAttributes(i, qLength, style, true);
			}
		}
	}

	//#endif

	//#ifdef regex
	public boolean searchRegx(String _query) {
		Pattern pattern;
		Matcher matcher;
		StyledDocument doc;
		Style style;
		
		if (_query.isEmpty()) {
			this.show();
			return true;
		}
		
		try {
			
			pattern = Pattern.compile(_query);
			matcher = pattern.matcher(strB.toString());
			doc = this.getStyledDocument();
			
			style = this.addStyle("styleRed", null);
			StyleConstants.setForeground(style, Color.BLACK);
			doc.setCharacterAttributes(0, doc.getLength(), style, true);
			StyleConstants.setForeground(style, Color.red);
			while (matcher.find()) {
				doc.setCharacterAttributes(matcher.start(),
						(matcher.end() - matcher.start()), style, true);
			}
		} catch (PatternSyntaxException e) {
			return false;
		}
		return true;
	}
	//#endif
}
