package vistana.challenge.dao;

import java.util.Map;

import org.springframework.stereotype.Component;

import vistana.challenge.data.SecurityQuestions;

@Component
public class SystemUserDaoImpl implements SystemUserDao {

	@Override
	public Map<Integer, String> getSecurityQuestions() {
		return SecurityQuestions.getQuestions();
	}

}
