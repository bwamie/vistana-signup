package vistana.challenge.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vistana.challenge.dao.SystemUserDao;
import vistana.challenge.util.Utils;

@Service
public class SystemUserServiceImpl implements SystemUserService{
	
	@Autowired
	SystemUserDao systemUserDao;

	@Override
	public Map<Integer, String> getThreeSecurityQuestions() {
		Map<Integer, String> allQns = systemUserDao.getSecurityQuestions();
		return getRandomQuestions(allQns);
	}
	
	@Override
	public Map<Integer, String> getAllSecurityQuestions() {
		Map<Integer, String> allQns = systemUserDao.getSecurityQuestions();
		return allQns;
	}
	
	private Map<Integer, String> getRandomQuestions(Map<Integer, String> allQns) {
		Map<Integer, String> threeRandomQns = new HashMap<>();
		int count = 0;
		int start = 1;
		int end = allQns.size();
		int qn = Utils.getRndomNumberInRange(start, end);
		while(count < 3) {
			while(threeRandomQns.containsKey(qn)) {
				qn = Utils.getRndomNumberInRange(start, end);
			}
			threeRandomQns.put(qn, allQns.get(qn));
			count++;
		}
		return threeRandomQns;
	}

}
