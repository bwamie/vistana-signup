package vistana.challenge.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vistana.challenge.domain.SystemUser;

@Controller
public class MainController {
	
	private final static Log logger = LogFactory.getLog(MainController.class);

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index() {
		logger.info("At index page :::::::::::::::::::: ");	
		return "index";
	}
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String index2() {
		logger.info("At index page :::::::::::::::::::: ");	
		return "index";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		SystemUser sessionSystemUser = (SystemUser)session.getAttribute("systemUser");
		if(sessionSystemUser != null) {
			model.addAttribute("message", "Welcome "+sessionSystemUser.getUsername()+" you are logged in successfully.");
			return "home";
		}else {
			model.addAttribute("message", "Your session expired or you are not logged in.");
			return "login";
		}
	}

	 @RequestMapping("/error")
	 public String error() {
	 return "error";
	 }

}