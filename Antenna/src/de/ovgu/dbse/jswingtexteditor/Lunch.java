package de.ovgu.dbse.jswingtexteditor;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * start the application.
 * 
 * @author Jan
 *
 */
public class Lunch {
	public static void main(final String... _args){
		Runnable	guiCreator;
		guiCreator = new Runnable() {

			public void run() {
				MainFrame	mainFrame;
				
				mainFrame = new MainFrame();
				mainFrame.setVisible(true);
//				
//				
//				
//				 JTextPane textPane = new JTextPane();
//			        StyledDocument doc = textPane.getStyledDocument();
//
//				Style style = textPane.addStyle("I'm a Style", null);
//				StyleConstants.setForeground(style, Color.red);
//				
//				try {
//					doc.insertString(doc.getLength(), "BLAH ", style);
//				} catch (BadLocationException e) {
//				}
//				
//				StyleConstants.setForeground(style, Color.blue);
//				
//				try {
//					doc.insertString(doc.getLength(), "BLEH", style);
//				} catch (BadLocationException e) {
//				}
//				
//				JFrame frame = new JFrame("Test");
//				frame.getContentPane().add(textPane);
//			        frame.pack();
//			        frame.setVisible(true);
				
			}
		};
		SwingUtilities.invokeLater(guiCreator);
	}
}
