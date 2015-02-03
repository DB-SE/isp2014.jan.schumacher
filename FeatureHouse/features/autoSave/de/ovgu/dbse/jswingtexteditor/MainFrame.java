package de.ovgu.dbse.jswingtexteditor;

import java.util.TimerTask;
import java.util.Timer;

public class MainFrame extends JFrame {
	private void initGUI(){
		original();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				saveFile(currentFile, text);
			}
		}, 10000, 10000 );
	}
}
