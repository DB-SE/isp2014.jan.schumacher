import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TextSearch{
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
