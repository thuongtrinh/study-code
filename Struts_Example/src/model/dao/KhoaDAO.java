package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Khoa;

public class KhoaDAO {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaEE_Example";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}

	public ArrayList<Khoa> getListKhoa() {
		connect();
		String sql = "SELECT MaKhoa, TenKhoa FROM Khoa";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<Khoa> list = new ArrayList<Khoa>();
		Khoa khoa;
		try {
			while (rs.next()) {
				khoa = new Khoa();
				khoa.setMaKhoa(rs.getString("MaKhoa"));
				khoa.setTenKhoa(rs.getString("TenKhoa"));
				list.add(khoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
