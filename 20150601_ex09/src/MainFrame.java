import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MainFrame extends JFrame {
	private Container cp;
	private Container jifcp;
	private JScrollPane jsp;
	private JPanel jpnt;
	private JButton jbtnConnDB = new JButton("Conn.  DB");
	private JButton jbtnShowData = new JButton("Show Data");
	private JButton jbtnExit = new JButton("Exit");
	private JDesktopPane jdp = new JDesktopPane();
	private DBConnection dbconn;
	private JInternalFrame jif1;
	private ResultSet rs;
	private ResultSetMetaData meta;
	private JTextArea jta = new JTextArea();

	public MainFrame() {
		initComp();
	}

	private void initComp() {
		cp = getContentPane();
		setBounds(200, 100, 600, 600);
		cp.setLayout(new BorderLayout(3, 3));
		jpnt = new JPanel(new GridLayout(1, 4, 3, 3));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp.add(jpnt, BorderLayout.NORTH);
		cp.add(jdp, BorderLayout.SOUTH);
		jpnt.add(jbtnConnDB);
		jbtnConnDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dbconnection();
				if (dbconn != null) {
					jif1 = new JInternalFrame("DB Connected");
					jifcp = jif1.getContentPane();
					jif1.setBounds(0, 0, 400, 300);
					jdp.add(jif1);
					jif1.setVisible(true);
				}
			}
		});
		jpnt.add(jbtnShowData);
		jbtnShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showData();
			}
		});
		jpnt.add(jbtnExit);
		jbtnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
	}

	private void dbconnection() {
		dbconn = new DBConnection(this, "csieuser", "c8ie6l01");
	}

	private void showData() {
		try {
			rs = dbconn.getData();
			int colCount = 0;

			if (rs != null) {
				jsp = new JScrollPane(jta);
				meta = rs.getMetaData();
				colCount = meta.getColumnCount();
				while (rs.next()) {
					String[] record = new String[colCount];
					for (int i = 0; i < colCount; i++) {
						record[i] = rs.getString(i + 1);
						jta.append(record[i] + "\t");
					}
					jta.append("\n");
				}
				jifcp.add(jsp);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
}