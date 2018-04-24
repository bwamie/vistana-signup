package vistana.challenge.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import vistana.challenge.domain.Pair;
import vistana.challenge.domain.SystemUser;
import vistana.challenge.service.SystemUserService;
import vistana.challenge.validator.UserValidator;

@Controller
@SessionAttributes("systemUser")
public class SystemUserController {

	@Autowired
	SystemUserService systemUserService;

	@Autowired
	private UserValidator userValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String getSugnupForm(SystemUser systemUser) {
		return "signup";
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public String addUser(HttpSession session, @ModelAttribute("systemUser") @Validated SystemUser systemUser, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errorMsg", "Errors on the form. Ensure all field correctly.");
			return "signup";
		}

		session.setAttribute("systemUser", systemUser);
		Map<Integer, String> threeRandomSecurityQuestions = systemUserService.getThreeSecurityQuestions();
		Map<Integer, String> allSecurityQuestions = systemUserService.getAllSecurityQuestions();
		spreadSecurityQns(systemUser, threeRandomSecurityQuestions);
		model.addAttribute("allSecurityQuestions", allSecurityQuestions);
		return "signup-qns";
	}

	@RequestMapping(value = { "/signup-qns" }, method = RequestMethod.POST)
	public String addUserSecurityQuestions(HttpSession session, WebRequest request, Model model) {
		SystemUser systemUser = (SystemUser) session.getAttribute("systemUser");
		Map<Integer, String> allQns = systemUserService.getAllSecurityQuestions();
		Map<Integer, Pair<String, String>> qnsAndAnswersMap = new HashMap<>();

		for (int i = 1; i <= 3; i++) {
			int qn = Integer.parseInt(request.getParameter("qn" + i).toString());
			String ans = request.getParameter("ans" + i).toString();
			Pair<String, String> qnAndAnswer = new Pair<>(allQns.get(qn), ans);
			qnsAndAnswersMap.put(qn, qnAndAnswer);
		}
		systemUser.setSecurityQuestions(qnsAndAnswersMap);
		model.addAttribute("message", "You have signup successfully!");
		return "index";
	}

	private void spreadSecurityQns(SystemUser systemUser, Map<Integer, String> securityQuestions) {
		Map<Integer, Pair<String, String>> qnsAndAnswersMap = new HashMap<>();
		for (Integer id : securityQuestions.keySet()) {
			String qn = securityQuestions.get(id);
			Pair<String, String> qnAndAnswer = new Pair<>(qn, "");
			qnsAndAnswersMap.put(id, qnAndAnswer);
		}
		systemUser.setSecurityQuestions(qnsAndAnswersMap);
	}

}
