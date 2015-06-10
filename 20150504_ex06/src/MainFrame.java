/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/05/04
 * 	Uses: 視窗及網路程式設計練習
 * 	Java JDK: 1.6
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.net.*;
import java.io.*;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.DropMode;


public class MainFrame extends JFrame {

	private JPanel contentPane = new JPanel();;
	private JTextField textField_1 = new JTextField("http://120.108.111.181");;
	private JTextArea textArea = new JTextArea();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnExut = new JButton("Exit");
		JLabel jlb1 = new JLabel("URL");
		jlb1.setHorizontalAlignment(SwingConstants.CENTER);
		btnExut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnExut, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		panel.add(jlb1);
		
		
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					textArea.setText("");
					InetAddress adr = InetAddress.getLocalHost();
					textArea.append("HostAddress: "+adr.getHostAddress()+"\nHostName: "+adr.getHostName()+"\n");
					textArea.append("==============================\n");
					URL u1 = new URL(textField_1.getText());
					URLConnection uc1 = u1.openConnection();
					textArea.append("通訊協定: "+u1.getProtocol()+"\n");
					textArea.append("HostName: "+u1.getHost()+"\n");
					textArea.append("Port: "+u1.getPort()+"\n");
					textArea.append("檔案為: "+u1.getFile()+"\n");
					textArea.append("主網頁大小 : "+uc1.getContentLength()+"\n");
					textArea.append("主網頁檔案類型 : "+uc1.getContentType()+"\n");
				} catch (UnknownHostException ee){
					System.out.println("無法取得IP位址");
				} catch (Exception ee){
					System.out.println(e);
				}
			}
		});
		panel.add(btnRun);
		
		
		contentPane.add(textArea, BorderLayout.CENTER);
		
	}

}
