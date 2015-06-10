import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainFrame1 extends JFrame  {
	public MainFrame1(){
		initComp();
	}
	private Container cp;
	private JPanel jpn1 = new JPanel();
	private JPanel jpn2 = new JPanel();
	private JButton jbtnExit = new JButton("Exit");
	private JButton jbtn1 = new JButton("Thread");
	
	private void initComp(){
		this.setBounds(100, 100, 500, 500);
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		jpn1.setLayout(new GridLayout(3,1,5,5));
		cp.add(jpn1,BorderLayout.EAST);
		jpn1.add(jbtn1);
		jpn1.add(jbtnExit);
		jpn2.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp.add(jpn2, BorderLayout.CENTER);
		
		jbtn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				TestLab tLab = new TestLab((int)(Math.random()*20000)+"");
				jpn2.add(tLab);
				Thread tk = new Thread(tLab);
				tk.start();
			}
		});
		jbtnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
}
