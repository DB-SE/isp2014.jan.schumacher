package de.ovgu.dbse.jswingtexteditor; 

import java.awt.BorderLayout; 
import java.awt.GridLayout; import java.io.File; 
import java.util.ArrayList; 
import java.util.List; 

import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 

import de.ovgu.dbse.jswingtexteditor.menu.*; import de.ovgu.dbse.jswingtexteditor.search.*; 
import java.util.TimerTask; 
import java.util.Timer; 
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 

import de.ovgu.dbse.jswingtexteditor.TextEditView; 

public   class  MainFrame  extends JFrame {
	
	public static File	currentFile;

	
	TextEditView text;

	

	public MainFrame() {
		
		this.setTitle("TextEditor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		text = new TextEditView();
		initGUI();
	}

	
	 private void  initGUI__wrappee__core  (){
		JScrollPane scrollPane = new JScrollPane(text.getPane());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	
	 private void  initGUI__wrappee__control  (){
		initGUI__wrappee__core();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		for (MenuApi menu : this.getMenus(text)) {
			panel.add(menu.getMenuComponent());
		}
	}

	
	
	 private void  initGUI__wrappee__search() {
		initGUI__wrappee__control();
		TextSearch search;
		
		search = new TextSearch();
		search.addText(this.text);
		getContentPane().add(search.getComp(), BorderLayout.SOUTH);
	}

	
	private void initGUI(){
		initGUI__wrappee__search();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				saveFile(currentFile, text);
			}
		}, 10000, 10000 );
	}

	
	 private List<MenuApi>  getMenus__wrappee__control  (TextEditView _text){
		List<MenuApi> menus;
		menus = new ArrayList<MenuApi>();
		return menus;
	}

	
	 private List<MenuApi>  getMenus__wrappee__Toolbar  (TextEditView _text){
		List<MenuApi> menus;
		menus = getMenus__wrappee__control(_text);
		menus.add(new ToolbarMenu(_text));
		return menus;
	}

	
	private List<MenuApi> getMenus(TextEditView _text) {
		List<MenuApi> menus;
		menus = getMenus__wrappee__Toolbar(_text);
		menus.add(0, new MainMenuBar(_text));
		return menus;
	}

	
	public static  void saveFile(File _file, TextEditView _text){
		if(_file == null || _text == null){
			return;
		}
		try {
			PrintWriter out;
			out = new PrintWriter(_file);
			out.print(_text.getContentString());
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
