package de.ovgu.dbse.jswingtexteditor;

/**
 * interface for different types of text.
 * e.g.: - only view text,
 * 		 - edit text.
 * @author Jan
 *
 */
public interface TextOutput {

	public void appendLine(String _line);
	public void clean();
}
