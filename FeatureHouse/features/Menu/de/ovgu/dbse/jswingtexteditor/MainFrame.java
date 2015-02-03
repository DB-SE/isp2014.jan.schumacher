package de.ovgu.dbse.jswingtexteditor;

public class MainFrame extends JFrame {
	private List<MenuApi> getMenus(TextEditView _text) {
		List<MenuApi> menus;
		menus = original(_text);
		menus.add(0, new MainMenuBar(_text));
		return menus;
	}
}
