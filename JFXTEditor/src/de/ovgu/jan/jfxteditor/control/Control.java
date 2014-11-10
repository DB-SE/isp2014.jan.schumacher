package de.ovgu.jan.jfxteditor.control;

import java.io.File;
import java.nio.file.Files;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import de.ovgu.jan.jfxteditor.TextScene;

abstract class Control {
	protected Scene		scene;
	protected Stage		stage;
	protected TextScene	text;

	public Control(Scene _scene, Stage _stage, TextScene _text) {
		this.scene = _scene;
		this.stage = _stage;
		this.text  = _text;
	}
	
	protected void openFile() {
		File		file;
		FileChooser	fileChooser;

		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("TXT", "*.txt"));
		file = fileChooser.showOpenDialog(this.stage);
		if (file != null && file.isFile()) {
			try {
				Files.lines(file.toPath()).map(line -> line + '\n')
				.forEach(this.text::appendToTextScene);
			} catch (Exception e1) {
				this.text.setTextScene(e1.getMessage());
			}
		}
	}
}
