import javax.swing.JToolBar;

public class ToolbarMenu {
	private void addIcons(JToolBar toolBar){
		original(toolBar);
		addIcon(toolBar, "res/icon/document-save-7.png", getSaveFileListner());
	}
}
