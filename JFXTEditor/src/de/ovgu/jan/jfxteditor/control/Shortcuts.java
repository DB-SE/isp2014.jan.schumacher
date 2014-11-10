package de.ovgu.jan.jfxteditor.control;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import de.ovgu.jan.jfxteditor.TextScene;

public class Shortcuts extends Control{
	
	public Shortcuts(Scene _scene, Stage _stage, TextScene _text) {
		super(_scene, _stage, _text);
		this.scene.setOnKeyPressed(e -> {
			if (e.isControlDown() && e.getCode().equals(KeyCode.O)) {
				this.openFile();
			}
		});
	}
	
	
}
