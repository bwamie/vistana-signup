package vistana.challenge.service;

import java.util.Map;

public interface SystemUserService {
	
	public Map<Integer, String> getThreeSecurityQuestions();
	
	public Map<Integer, String> getAllSecurityQuestions();

}
