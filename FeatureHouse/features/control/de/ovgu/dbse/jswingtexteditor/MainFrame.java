public class MainFrame extends JFrame {
	private void initGUI(){
		original();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		for (MenuApi menu : this.getMenus(text)) {
			panel.add(menu.getMenuComponent());
		}
	}
	private List<MenuApi> getMenus(TextEditView _text){
		List<MenuApi> menus;
		menus = new ArrayList<MenuApi>();
		return menus;
	}
}
