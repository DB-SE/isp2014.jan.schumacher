import javax.swing.JTextPane;
import javax.swing.UIManager;

import de.ovgu.dbse.jswingtexteditor.TextEditView;


public aspect show {
	void around(TextEditView textView) : execution(* de..TextEditView.initial(..)) && this(textView){
		JTextPane pane = textView.getPane();
		pane.setEditable(false);  
		pane.setCursor(null);  
		pane.setOpaque(false);  
		pane.setFocusable(false);
		pane.setFont(UIManager.getFont("Label.font"));
	}
}
