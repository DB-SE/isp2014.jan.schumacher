package de.ovgu.dbse.jswingtexteditor;

import javax.swing.JLabel;
/**
 * only show text.
 * @author Jan
 *
 */
public class TextView extends JLabel implements TextOutput{
	StringBuilder strB = new StringBuilder();

	@Override
	public void appendLine(String _line) {
		this.strB.append(_line);
		this.strB.append('\n');
		this.setText(this.strB.toString());
	}
	@Override
	public void clean() {
		this.strB.setLength(0);
		this.setText(new String());
	}
}
