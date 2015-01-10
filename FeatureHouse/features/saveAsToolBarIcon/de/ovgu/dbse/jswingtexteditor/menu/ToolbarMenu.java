import javax.swing.JToolBar;

public class ToolbarMenu extends MenuApi {
	private void addIcons(JToolBar toolBar){
		original(toolBar);
		addIcon(toolBar, "res/icon/document-save-as-6.png",
				getSaveAsFileListner(toolBar));
	}
}
