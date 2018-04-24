package vistana.challenge.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import vistana.challenge.domain.SystemUser;

@Controller
@SessionAttributes("systemUser")
public class LoginController { 

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(@ModelAttribute("newSystemUser") SystemUser systemUser) {
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	@ResponseBody public String loginRequest(HttpSession session, Model model, WebRequest request) {
		String username = request.getParameter("username").toString();
		SystemUser sessionSystemUser = (SystemUser)session.getAttribute("systemUser");
		if(sessionSystemUser != null && username != null && username.equals(sessionSystemUser.getUsername())) {
			model.addAttribute("username", username);
			session.setAttribute("LOGGEDIN", true); 
			return "ok";
		}else {
			return "no";
		}
		
	}
	
	@RequestMapping(value = { "/login-qns" }, method = RequestMethod.GET)
	public String loginRequestQnsGET(HttpSession session, Model model, WebRequest request) {
		String username = request.getParameter("username").toString();
		SystemUser sessionSystemUser = (SystemUser)session.getAttribute("systemUser");
		if(sessionSystemUser == null || !username.equals(sessionSystemUser.getUsername())) {
			model.addAttribute("message", "Username not found!");
			return "login";
		}else {		
			model.addAttribute("username", username);
			return "login-qns";
		}
		
	}
	
	@RequestMapping(value = { "/login-qns" }, method = RequestMethod.POST)
	public String loginRequestQns(HttpSession session, Model model, WebRequest request) {
		String username = request.getParameter("username").toString();
		SystemUser sessionSystemUser = (SystemUser)session.getAttribute("systemUser");
		if(sessionSystemUser == null || !username.equals(sessionSystemUser.getUsername())) {
			model.addAttribute("message", "Username not found!");
			return "login";
		}else {			
			for(int qn: sessionSystemUser.getSecurityQuestions().keySet()) {
				String expectedAns = sessionSystemUser.getSecurityQuestions().get(qn).getAnswer();
				String inputAnswer = request.getParameter("ans"+qn);
				if(inputAnswer == null || !inputAnswer.equalsIgnoreCase(expectedAns)) {
					model.addAttribute("username", username);
					model.addAttribute("message", "Questions answers do not match answers in our records. Try again!");
					return "login-qns";
				}
			}
			
			model.addAttribute("message", "Welcome " +sessionSystemUser.getUsername()+ ".  You are successlly logged in.");
			return "home";
		}
		
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("LOGGEDIN"); 
		return "index";
	}
	
	@RequestMapping(value = { "/reset-account" }, method = RequestMethod.GET)
	public String resetAccount(SessionStatus status) {
		status.setComplete();
		return "index";
	}

}
