package sql.chen.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/*
 * 插入时间
 */
public class Demo4 {
public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement ps=null;
	try {
		Class clzz=Class.forName("com.mysql.jdbc.Driver");
		//建立连接(socket)耗时多
		 conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestJdbc",
				"root","123456");
		/*
		 * Preparestatment
		 */
		String str="insert into testdate (name,Date) values (?,?)";
		for(int i=0;i<1000;i++) {
		int time=50000000+new Random().nextInt(400000000);
		Date date=new Date(System.currentTimeMillis()-time);
		 ps=conn.prepareStatement(str);
		 ps.setString(1, "chen"+i);
		 ps.setDate(2, date);
		 ps.execute();
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
	}
}
}
