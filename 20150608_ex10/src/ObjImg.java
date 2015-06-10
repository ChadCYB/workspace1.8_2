import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ObjImg extends Thread {
	private Timer t1;
	int x = 60, y = 60;
	GraphicPanel gPn1;

	public ObjImg(GraphicPanel gp1) {
		gPn1 = gp1;
	}

	public void run() {
		t1 = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (y < gPn1.getHeight() - 40) {
					y += 20;
					gPn1.setObj(1, x, y);
					gPn1.repaint();
				} else {
					t1.stop();
				}
			}
		});
		t1.start();
	}
}
