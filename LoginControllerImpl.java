package com.rtgs.controllers.impl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rtgs.controllers.LoginController;
import com.rtgs.db.model.AdminDTO;
import com.rtgs.model.AdminModel;
import com.rtgs.service.ServiceDao;
import com.rtgs.service.impl.ServiceDaoImpl;




@Controller
@RequestMapping("/admin")


public class LoginControllerImpl implements LoginController {
	
	@Autowired
	@Qualifier("dao_based_service")
	private ServiceDao service;
	
	
	public LoginControllerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	@RequestMapping(value = "/login")
	public String showLoginForm(Model map) {
		System.out.println("in show login form ");
		// add like MDI in struts -- EMPTY model instance to the map
		map.addAttribute("adminModel", new AdminDTO());
		return "adminLogin";
	}
	
	
	
	
	
	
	// method for processing login form
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String processLoginForm(
				@Valid @ModelAttribute("adminModel") AdminDTO m, BindingResult res,
				Model map, HttpSession hs) {
			System.out.println("in process login form " + m);
			// chk for p.l errs
			if (res.hasFieldErrors("adminId") || res.hasFieldErrors("pass")) {
				// p.l errs
				System.out.println("P.L errors");
				return "login";
			}
			System.out.println("no p .l errs");
			// use service layer bean for validation
			AdminDTO details = service.validateAdmin(m.getAdminId(), m.getPassword());
			if (details == null)
				return "invalid";
			// successful B.L validations
			// add validated cust details to model attr map
			map.addAttribute("valid_cust", details);
			map.addAttribute("status", "Logged in Successfully");
			System.out.println("login " + hs.getId());
			// add validated user dtls to session scope
			hs.setAttribute("valid_cust", details);
			return "upload";
		}
	
	
	
	
	
	
}
