import java.awt.Color;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import de.ovgu.dbse.jswingtexteditor.TextEditView;


public aspect regex {
	JToggleButton toggleRegx;
	Component around(TextEditView text) : execution(*  initSearch(*))&& args(text) {
		Component org = proceed(text); 
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setEnabled(false);
		
		toggleRegx = new JToggleButton("Regx");
		toggleRegx.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane.setRightComponent(toggleRegx);
		splitPane.setLeftComponent(org);
		return splitPane;
	}
	void around(String _query, TextEditView _text) : call(* search.search(..)) &&args(_query,_text){
		if (toggleRegx.isSelected()) {
			search(_query, _text);
		} else {
			proceed(_query, _text);
		}
	}
	private void search(String _query, TextEditView _text) {
		Pattern pattern;
		Matcher matcher;
		StyledDocument doc;
		Style style;
		
		if (_query.isEmpty()) {
			_text.show();
			return;
		}
		
		try {
			pattern = Pattern.compile(_query);
			matcher = pattern.matcher(_text.getContentString());
			doc     = _text.getStyledDocument();
			
			style = _text.addStyle("styleRed", null);
			StyleConstants.setForeground(style, Color.BLACK);
			doc.setCharacterAttributes(0, doc.getLength(), style, true);
			StyleConstants.setForeground(style, Color.red);
			while (matcher.find()) {
				doc.setCharacterAttributes(matcher.start(),
						(matcher.end() - matcher.start()), style, true);
			}
		} catch (PatternSyntaxException e) {
			_text.show();
		}
	}
}
