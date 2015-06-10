import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ObjL extends Thread{
	private int type;
	private Timer t1;
	int x = 20, y = 0;
	GraphicPanel gPn1;
	public ObjL(GraphicPanel gp1){
		gPn1 = gp1;
	}
	public void run(){
		type = new java.util.Random().nextInt(4);
		t1 = new Timer(500, new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(y < gPn1.getHeight()-40){
					y+=20;
					gPn1.setObj(0, x, y);
					gPn1.repaint();
				}else{
					t1.stop();
					stopThread();	//¹Ï¤ù¨ì©³°±¤î
				}
			}
		});
		t1.start();
	}
	private void stopThread(){
		this.stop();
	}
}
