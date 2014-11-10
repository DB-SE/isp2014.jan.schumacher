package de.ovgu.jan.jfxteditor;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import de.ovgu.jan.jfxteditor.control.ControlMenu;


public class MainApp extends Application {
	private static String	SHORTCUT_KEY	= "sc";
	private static String	MENU_KEY		= "menu";
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage _stage) throws Exception {
		TextScene	text;
		Scene		scene;
		VBox		vBox;
		String		value;
		boolean		useShorcuts;
		ControlMenu	menu;
		MenuBar		menuBar;
		
		text  = new TextShowScene();
		vBox  = new VBox();
		scene = new Scene(vBox, 400, 300);

		value       = this.getParameters().getNamed().get(SHORTCUT_KEY);
		useShorcuts = value != null && value.equals("true");
	
		menu    = new ControlMenu(scene, _stage, text, useShorcuts);
		menuBar = menu.getMenuBar();
		value   = this.getParameters().getNamed().get(MENU_KEY);
		menuBar.setVisible(value != null && value.equals("true"));
		vBox.getChildren().add(menuBar);
		vBox.getChildren().add((Node) text);
		
		_stage.setTitle("JFXTEditor");
		_stage.setScene(scene);
		_stage.show();
	}
	
}
