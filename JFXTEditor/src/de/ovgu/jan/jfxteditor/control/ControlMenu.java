package de.ovgu.jan.jfxteditor.control;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import de.ovgu.jan.jfxteditor.TextScene;

public class ControlMenu extends Control {
	private boolean useShorcuts;
	public ControlMenu(Scene _scene, Stage _stage, TextScene _text, boolean _useShorcuts) {
		super(_scene, _stage, _text);
		this.useShorcuts = _useShorcuts;
	}
	public MenuBar getMenuBar(){
		MenuBar		menuBar;
		Menu		menuFile;
		Menu		menuHelp;
		MenuItem	openFile;
		
		
		menuFile = new Menu("File");
		menuHelp = new Menu("Help");
		openFile = new MenuItem("Open");
		openFile.setOnAction(e -> this.openFile());
		menuFile.getItems().add(openFile);
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(menuFile,menuHelp);
		if(this.useShorcuts) {
			openFile.setAccelerator(new KeyCodeCombination(KeyCode.O,
					KeyCombination.CONTROL_DOWN));
		}
		return menuBar;
	}
}
