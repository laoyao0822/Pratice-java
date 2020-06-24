package sql.chen.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo2 {
public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		Class clzz=Class.forName("com.mysql.jdbc.Driver");
		//建立连接(socket)耗时多
		 conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestJdbc",
				"root","123456");
		
		String str="SELECT id,uname,upwd,Time FROM test where id>?";
		ps=conn.prepareStatement(str);
		ps.setObject(1,0);
		rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getInt(3)+"----"+rs.getDate(4));
		}
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
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}
