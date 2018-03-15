package com.fcar.basics.utils;

import java.sql.*;
public class GetMysqlData {
	
	public static void Mysql(String sql) throws ClassNotFoundException, SQLException{
		
	    // 1.加载数据访问驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接到数据"库"上去
        Connection conn= DriverManager.getConnection("jdbc:mysql://rm-2zeekn084y04f2h2i.mysql.rds.aliyuncs.com/kl_admin?characterEncoding=UTF-8", "kl_admin", "kl_admin_00");
        //3.构建SQL命令
        Statement state=conn.createStatement();
        String s = sql;
        state.executeUpdate(s);
       // state.executeQuery(s);
        state.close();
		conn.close();
		
	}

}
