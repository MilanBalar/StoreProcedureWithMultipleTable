package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bean.LoginBean;
import com.bean.StudentBean;

public class DAO {

	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public List findUser(String email, String pwd) {
		Boolean flag = false;
		String sql = "from StudentBean u where u.semail=? and u.spwd=?";
		List c = ht.find(sql, email, pwd);
		return c;

	}

	static CallableStatement ps;

	/*
	 * public static List<MobileInfo> callProcedure_2() throws
	 * ClassNotFoundException, SQLException {
	 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); Connection con
	 * = DriverManager.getConnection(
	 * "jdbc:sqlserver://192.168.100.55:1440;databaseName=eTest", "milan",
	 * "F~?'7{e{"); ps = con.prepareCall("{CALL tables()}");
	 * 
	 * List<MobileInfo> l1 = new ArrayList<MobileInfo>();
	 * 
	 * System.out.println("Contents of the second result-set"); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) { MobileInfo m = new MobileInfo();
	 * m.setId(rs.getInt(1)); m.setAmount(rs.getInt(3)); m.setName(rs.getString(2));
	 * m.setTotal(rs.getInt(4)); l1.add(m);
	 * 
	 * }
	 * 
	 * return l1;
	 * 
	 * }
	 */
	public static List<LoginBean> callProcedure() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.100.55:1440;databaseName=eTest", "milan",
				"F~?'7{e{");
		ps = con.prepareCall("{CALL tables()}");
		ResultSet rs = ps.executeQuery();

		List<LoginBean> l = new ArrayList<LoginBean>();
		LoginBean b;
		while (rs.next()) {
			b = new LoginBean();

			if (rs.getInt("id") > 0) {
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				b.setContact(rs.getInt("contact"));
				l.add(b);
			}

		}

		/* List<MobileInfo> l1 = new ArrayList<MobileInfo>(); */

		System.out.println("Contents of the second result-set");
		ps.getMoreResults();
		ResultSet rs2 = ps.getResultSet();

		while (rs2.next()) { /* MobileInfo m = new MobileInfo(); */
			b = new LoginBean();

			b.setSid(rs2.getInt("id"));
			b.setAmount(rs2.getInt("amount"));
			b.setSname(rs2.getString("name"));
			b.setTotal(rs2.getInt("total"));
			l.add(b);

		}

		return l;
	}

	@Transactional
	public void saveData(StudentBean b) {
		ht.save(b);

	}

}
