public class MainFrame extends JFrame {
	private List<MenuApi> getMenus(TextEditView _text){
		List<MenuApi> menus;
		menus = original(_text);
		menus.add(new ToolbarMenu(_text));
		return menus;
	}
}
