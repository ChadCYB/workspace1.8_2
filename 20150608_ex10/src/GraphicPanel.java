import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class GraphicPanel extends JPanel {
	private int x = 20, y = 0;
	private int type = 0;
	private Color c = Color.ORANGE;
	private Image img = Toolkit.getDefaultToolkit().getImage(
			"Small-mario.png");

	public GraphicPanel() {
	}

	public void paintComponent(Graphics gL) {
		gL.setColor(c);
		switch (type) {
		case 0:
			gL.fillRect(x, y, 100, 100);
			break;
		case 1:
			gL.drawImage(img, x, y, x + 32, y + 32, this); // 將圖形下降
			break;
		}
	}

	public void setLocation(int x1, int y1) {
		x = x1;
		y = y1;
	}

	public void setObj(int flag, int x1, int y1) {
		x = x1;
		y = y1;
		type = flag;
	}
}
