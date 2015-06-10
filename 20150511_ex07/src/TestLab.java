import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class TestLab extends JLabel implements Runnable{
	private String str;
	private Timer t1;
	public TestLab(String ss){
		setBounds((int)(Math.random()*360+1),0,100,25);			//設定X起始點
//		str = ss;
		str = "●";
		this.setForeground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));	//R,G,B,A透明度
		int rndTime = (int)(Math.random()*1000);
		this.setText(str);
		
		t1 = new Timer(rndTime, new ActionListener(){				//啟動timer
			public void actionPerformed(ActionEvent e){			//移動一固定亂數
//				setBounds(getX(), getY()+20, 100, 25);
				if(getY()<430) setBounds(getX(), getY()+20, 100, 25);
			}
		});
	}
	public void run(){
		t1.start();
	}
}
