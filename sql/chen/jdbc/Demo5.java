package sql.chen.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Demo5 {
public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		Class clzz=Class.forName("com.mysql.jdbc.Driver");
		//建立连接(socket)耗时多
		 conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestJdbc",
				"root","123456");
		String str="SELECT id,name,Date FROM testdate where Date>? and Date<?";
		ps=conn.prepareStatement(str);
		Date da1=new Date(strdateToLong("2020-5-10"));
		Date da2=new Date(strdateToLong("2020-5-12"));
		ps.setObject(1,da1);
		ps.setObject(2, da2);
		rs=ps.executeQuery();
		int i=0;
		while(rs.next()) {
			i++;
			System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getDate(3));
		}
		System.out.println(i);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
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
	public static long strdateToLong(String date) throws ParseException {
		DateFormat fo=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date da=fo.parse(date);
		long d=da.getTime();
		return d;
	}
}
