package de.ovgu.jan.jfxteditor;
import javafx.scene.text.Text;

public class TextShowScene extends Text implements TextScene{
	private StringBuilder strB;

	@Override
	public void appendToTextScene(String _string) {
		if (this.strB == null) {
			this.strB = new StringBuilder();
		}
		this.strB.append(_string);
		this.setText(this.strB.toString());

	}

	@Override
	public void clearTextScene() {
		this.strB = null;
	}
}
