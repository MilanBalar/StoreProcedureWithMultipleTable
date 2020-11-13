package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.StudentBean;
import com.dao.DAO;

@Controller
public class StuController {

	@Autowired
	DAO dao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(@RequestParam("semail") String semail, @RequestParam("spwd") String spwd, Model m) {

		List l = dao.findUser(semail, spwd);
		if (l != null && l.size() > 0) {

			StudentBean sid = (StudentBean) l.get(0);
			System.out.println("mY data is" + sid);
			m.addAttribute("data", sid);
			return "view";
		} else {
			return "notValide";
		}

	}

	@RequestMapping("/notValide")
	public String erro() {
		return "notValide";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePage(@RequestParam("sname") String sname, @RequestParam("semail") String semail,
			@RequestParam("scontact") Long scontact, @RequestParam("scity") String scity,
			@RequestParam("spwd") String spwd) {
		StudentBean b = new StudentBean();
		b.setSname(sname);
		b.setSemail(semail);
		b.setScontact(scontact);
		b.setScity(scity);
		b.setSpwd(spwd);

		dao.saveData(b);
		return "loginPage";
	}

}
