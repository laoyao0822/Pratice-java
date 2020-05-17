package sql.chen.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo01 {
public static void main(String[] args) {
	Connection conn=null;
	try {
		Class clzz=Class.forName("com.mysql.jdbc.Driver");
		//建立连接(socket)耗时多
		 conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestJdbc",
				"root","123456");
		/*
		 * statement 
		 */
		//Statement sat=(Statement) conn.createStatement();
		//String str="insert into test (uname,upwd,Time) values (\"hu\",5555,NOW())";
//		String id="5 or 1=1";
//		String str="DELETE from test where id="+id;
//		sat.execute(str);
		/*
		 * Preparestatment
		 */
		String str="insert into test (uname,upwd,Time) values (?,?,?)";
		PreparedStatement ps=conn.prepareStatement(str);
		ps.setString(1,"chen3");
		ps.setInt(2,12345);
		ps.setDate(3,new Date(System.currentTimeMillis()));
		ps.execute();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}
