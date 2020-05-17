package sql.chen.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//测试批处理
public class Demo3 {
public static void main(String[] args) {
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	try {
		Class clzz=Class.forName("com.mysql.jdbc.Driver");
		//建立连接(socket)耗时多
		 conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestJdbc",
				"root","123456");
		conn.setAutoCommit(false);//取消自动提交
		long time01=System.currentTimeMillis();
		st=conn.createStatement();
		for(int i=0;i<10000;i++) {
			st.addBatch("insert into test_user (name,pwd,Date) values ('gao"+i+"',5555,NOW())");
		}
		st.executeBatch();
		conn.commit();
		long time02=System.currentTimeMillis();
		System.out.println(time02-time01);
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
		if(st!=null) {
			try {
				st.close();
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
