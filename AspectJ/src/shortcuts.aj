import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public aspect shortcuts {
	JMenuItem around(String name, ActionListener actionListener) : execution(* addMenuItem(..))&&args(name,actionListener) {
		int keyCode = -1;
		int modifiers = -1;
		
		JMenuItem item = proceed(name, actionListener);
		switch (name) {
			case "Open":
				keyCode = KeyEvent.VK_O;
				modifiers = InputEvent.CTRL_MASK;
				break;
			case "Save":
				keyCode = KeyEvent.VK_S;
				modifiers = InputEvent.CTRL_MASK;
				break;
			
			default:
				return item;
		}
		item.setAccelerator(KeyStroke.getKeyStroke(keyCode, modifiers));
		return item;
	}
}
