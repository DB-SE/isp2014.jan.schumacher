package de.ovgu.dbse.jswingtexteditor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
/**
 * the frame which is started and has the main content.
 * @author Jan
 *
 */
public class MainFrame extends JFrame {
	public MainFrame() {
		final TextView textView;

		this.setTitle("TextEditor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		textView = new TextView();
		JScrollPane scrollPane = new JScrollPane((Component) textView);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
//		this.getContentPane().add(, BorderLayout.CENTER);
	
		//#ifdef Menu
		JMenuBar menuBar = new MainMenu(textView);
		panel.add(menuBar);
		//#endif
		//#ifdef Toolbar
		JToolBar toolBar = new ToolbarMenu(textView);
		panel.add(toolBar);
		//#endif

		//#ifdef search
		final JTextField edit;
		edit = new JTextField();
		//#ifdef regex
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setEnabled(false);
		getContentPane().add(splitPane, BorderLayout.SOUTH);
		
		final JToggleButton toggleRegx = new JToggleButton("Regx");
		toggleRegx.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane.setRightComponent(toggleRegx);
		toggleRegx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					textView.searchRegx(edit.getText());
				} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
					textView.search(edit.getText());
				}
			}
		});
		//#endif
		
		//#ifdef regex
		splitPane.setLeftComponent(edit);
		//#else
//@		getContentPane().add(edit, BorderLayout.SOUTH);
		//#endif
		edit.getDocument().addDocumentListener( new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				change();
			}
			
			public void insertUpdate(DocumentEvent e) {
				change();
			}
			public void changedUpdate(DocumentEvent e) {
				change();
			}
			
			private void change() {
				//#ifdef regex
				if (toggleRegx.isSelected()) {
					textView.searchRegx(edit.getText());
					return;
				} 
				//#endif
				textView.search(edit.getText());
			}
		});
		
		//#endif
	}
	
	public static void openFile(Component _root,TextView _out) {
		File			file;
		JFileChooser	fileChooser;
		BufferedReader	br;
		int				returnVal;
		String			line;
		
		fileChooser = new JFileChooser();
		returnVal   = fileChooser.showOpenDialog(_root);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				file = fileChooser.getSelectedFile();
				br   = new BufferedReader(new FileReader(file));
				_out.clean();
				while((line = br.readLine())!= null){
					_out.appendLine(line);
				}
				_out.show();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
