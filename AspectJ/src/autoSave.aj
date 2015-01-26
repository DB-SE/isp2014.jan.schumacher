import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import de.ovgu.dbse.jswingtexteditor.MainFrame;
import de.ovgu.dbse.jswingtexteditor.TextEditView;

public aspect autoSave {
	// TODO Auto-generated aspect
	after(MainFrame m) : call(* ..TextEditView.new()) && this(m) {
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(1);
		
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			File f = m.getCurrentFile();
			TextEditView t = m.getText();
			if (f != null && t != null)
				save.saveFile(m);
		}, 10, 10, TimeUnit.SECONDS);
		m.addWindowListener((CloseListner) e -> {
			scheduledExecutorService.shutdown();
		});
	}
	
	@FunctionalInterface
	private interface CloseListner extends WindowListener {
		@Override
		default void windowActivated(WindowEvent arg0) {
		}
		
		@Override
		default void windowClosing(WindowEvent e) {
		}
		
		@Override
		default void windowDeactivated(WindowEvent e) {
		}
		
		@Override
		default void windowDeiconified(WindowEvent e) {
		}
		
		@Override
		default void windowIconified(WindowEvent e) {
		}
		
		@Override
		default void windowOpened(WindowEvent e) {
		}
	}
}
