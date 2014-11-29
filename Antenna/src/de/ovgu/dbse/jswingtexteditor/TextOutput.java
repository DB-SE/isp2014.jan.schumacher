package de.ovgu.dbse.jswingtexteditor;

/**
 * interface for different types of text.
 * e.g.: - only view text,
 * 		 - edit text.
 * @author Jan
 *
 */
@Deprecated
public interface TextOutput {

	public void appendLine(String _line);
	public void clean();
	public void search(String _query);
}
