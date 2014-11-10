package de.ovgu.jan.jfxteditor;
/**
 * view text in gui.
 * @author Jan
 *
 */
public interface TextScene {
	/**
	 * append Text to the view.
	 * @param _string
	 */
	public void appendToTextScene(String _string);
	public void clearTextScene();
	public default void setTextScene(String _str){
		this.clearTextScene();
		this.appendToTextScene(_str);
	}
}
