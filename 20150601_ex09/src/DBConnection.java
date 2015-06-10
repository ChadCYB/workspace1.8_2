import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class DBConnection {
	private String driver ="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://120.108.117.245:3306/csieuser?useUnicode=true&characterEncoding=utf8";
	private Connection dbConn;
	private MainFrame frm;
	public DBConnection(MainFrame frm1,String id,String pw){
		frm=frm1;
		try{
			Class.forName(driver);
			dbConn=DriverManager.getConnection(url,id,pw);
			JOptionPane.showMessageDialog(frm, "資料庫連結成功");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(frm,ex.toString());
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(frm,ex.toString());
		}
	}
	
	public ResultSet getData(){
		ResultSet rs=null;
		try{
			Statement stm=dbConn.createStatement();
			String sqlStr="select*from student";
			rs=stm.executeQuery(sqlStr);
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(frm,ex.toString());
		}
		return rs;
	}
}
