package db;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.util.Vector;

public class DB {
Connection con=null;
java.sql.PreparedStatement pst;

public static Connection dbconnect()
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mychemist","root","Akash@2846");
		return conn;
	}
	catch(Exception e2){
		System.out.println(e2);
		return null;
	}
}
}
