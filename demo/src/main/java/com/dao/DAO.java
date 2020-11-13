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

	public static List<LoginBean> callProcedure() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.100.55:1440;databaseName=eTest", "milan",
				"F~?'7{e{");
		CallableStatement ps = con.prepareCall("{CALL tables()}");
		ResultSet rs = ps.executeQuery();
		List<LoginBean> l = new ArrayList<LoginBean>();

		while (rs.next()) {
			LoginBean b = new LoginBean();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setContact(rs.getInt(3));
			l.add(b);
		}

		return l;

	}

	@Transactional
	public void saveData(StudentBean b) {
		ht.save(b);

	}

}
