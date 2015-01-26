import java.util.Timer;
import java.util.TimerTask;

import de.ovgu.dbse.jswingtexteditor.MainFrame;


public aspect autoSave {
	// TODO Auto-generated aspect
	after(MainFrame m) : call(* ..TextEditView.new()) && this(m) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				MainFrame.saveFile(MainFrame.currentFile, m.getText());
			}
		}, 10000, 10000 );
	}
}
