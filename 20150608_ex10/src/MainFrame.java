import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private Container cp;
	private JPanel jpnC = new JPanel(new GridLayout(1, 2, 3, 3));
	private GraphicPanel gPn1 = new GraphicPanel();
	private JPanel jpnR = new JPanel();

	public MainFrame() {
		initComp();
	}

	private void initComp() {
		setVisible(true);
		this.setBounds(200, 100, 600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = getContentPane();
		setLayout(new BorderLayout(1, 1));
		cp.add(jpnC, BorderLayout.CENTER);
		gPn1.setBackground(Color.GRAY);
		jpnR.setBackground(Color.CYAN);
		gPn1.setOpaque(false);
		jpnC.add(gPn1);
		jpnC.add(jpnR);
		ObjL obj1 = new ObjL(gPn1);
		obj1.start();
	}
}
