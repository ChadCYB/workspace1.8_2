import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class TestLab extends JLabel implements Runnable{
	private String str;
	private Timer t1;
	public TestLab(String ss){
		setBounds((int)(Math.random()*360+1),0,100,25);			//�]�wX�_�l�I
//		str = ss;
		str = "��";
		this.setForeground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));	//R,G,B,A�z����
		int rndTime = (int)(Math.random()*1000);
		this.setText(str);
		
		t1 = new Timer(rndTime, new ActionListener(){				//�Ұ�timer
			public void actionPerformed(ActionEvent e){			//���ʤ@�T�w�ü�
//				setBounds(getX(), getY()+20, 100, 25);
				if(getY()<430) setBounds(getX(), getY()+20, 100, 25);
			}
		});
	}
	public void run(){
		t1.start();
	}
}
