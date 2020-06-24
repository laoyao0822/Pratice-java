package com.sql.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ¿˚”√javabean¥¢¥Ê
 */
public class Demo02 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=SQLUtils.getConnection();
		Map<Integer,Emp>map=new HashMap<>();
		String sql="SELECT uname,id,Time From test where id>?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,0);
			rs=ps.executeQuery();
			while(rs.next()) {
				Emp emp=new Emp(rs.getString(1),rs.getInt(2),rs.getDate(3));
				map.put(rs.getInt(2),emp);
			}
			for(Integer in:map.keySet()) {
				Emp temp=map.get(in);
				System.out.println(temp.getUname()+"--"+temp.getId()+"--"+temp.getDate());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLUtils.close(conn, ps, rs);
		}
	}
}
