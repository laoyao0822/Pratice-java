package sql.chen.jdbc;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 测试clob获取
 */

public class Demo7 {
public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		Class clzz=Class.forName("com.mysql.jdbc.Driver");
		//建立连接(socket)耗时多
		 conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestJdbc",
				"root","123456");
		
		String str="SELECT info FROM test_clob where id<?";
		ps=conn.prepareStatement(str);
		ps.setObject(1,3);
		
		rs=ps.executeQuery();
		while(rs.next()) {
			Clob clob=rs.getClob("info");
			Reader re=clob.getCharacterStream();
			int len=0;
			while((len=re.read())!=-1) {
				System.out.print((char)len);
			}
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
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
