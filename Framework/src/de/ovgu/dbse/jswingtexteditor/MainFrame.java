package de.ovgu.dbse.jswingtexteditor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.ovgu.dbse.jswingtexteditor.api.MenuApi;
import de.ovgu.dbse.jswingtexteditor.api.SearchApi;
import de.ovgu.dbse.jswingtexteditor.api.TextApi;
import de.ovgu.dbse.jswingtexteditor.plugins.MainMenu;
import de.ovgu.dbse.jswingtexteditor.plugins.TextEdit;
import de.ovgu.dbse.jswingtexteditor.plugins.TextSearchRegx;
import de.ovgu.dbse.jswingtexteditor.plugins.ToolbarMenu;

/**
 * the frame which is started and has the main content.
 *
 * @author Jan
 *
 */
public class MainFrame extends JFrame {
	public static File	currentFile;

	public MainFrame() {
		TextApi text;
		
		this.setTitle("TextEditor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		text = new TextEdit();
		JScrollPane scrollPane = new JScrollPane(text.getPane());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		List<MenuApi> menus;
		menus = new ArrayList<MenuApi>();
		menus.add(new MainMenu(text, true, true));
		menus.add(new ToolbarMenu(text, true, true));
		
		for (MenuApi menu : menus) {
			panel.add(menu.getMenuComponent());
		}
		
		SearchApi search;

		/*
		 * only one of the search at the same time
		 */
		// search = new TextSearch();
		search = new TextSearchRegx();
		search.addText(text);
		getContentPane().add(search.getComp(), BorderLayout.SOUTH);
	}
}
