package com.sql.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * 利用list与object数组储存
 */
public class Demo01 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=SQLUtils.getConnection();
		if(conn!=null) {
			System.out.println(2);
		}
		List <Object[]>list=new ArrayList<>();
		String sql="SELECT uname,id,Time From test where id>?";
		try {
			ps=conn.prepareStatement(sql);
			if(ps!=null) {
				System.out.println(2);
			}
			ps.setInt(1,0);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object []objs=new Object[3];
				objs[0]=rs.getString(1);
				objs[1]=rs.getInt(2);
				objs[2]=rs.getDate(3);
				list.add(objs);
				System.out.println(objs[0]+"--"+objs[1]+"---"+objs[2]);

			}
			System.out.println(1);
			for(Object[]temp:list) {
				System.out.println(temp[0]+"--"+temp[1]+"---"+temp[2]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLUtils.close(conn, ps, rs);
		}
	}
}
