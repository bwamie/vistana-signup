package vistana.challenge.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import vistana.challenge.data.SecurityQuestions;
import vistana.challenge.service.SystemUserServiceImpl;

public class SystemUserDaoImplTest {
	
//	@Mock
//	SystemUserDao systemUserDao;
//	SystemUserServiceImpl systemUserService;
	
	Map<Integer, String> expectedQuestions;
	SystemUserDao systemUserDao;

	@Before
	public void setupMock() {
		this.expectedQuestions = new HashMap<>();
		this.expectedQuestions.put(1, "What is your mother's maiden name?");
		this.expectedQuestions.put(2, "What is your favorite color?");
		this.expectedQuestions.put(3, "Who was you childhood friend?");
		this.expectedQuestions.put(4, "What is your favorite car?");
		this.expectedQuestions.put(5, "What is your favorite sport?");
		this.expectedQuestions.put(6, "What is your  favorite city?");
		systemUserDao = new SystemUserDaoImpl();
	}

	@After
	public void runOnceAfterClass() {
		this.expectedQuestions = null;
	}
		
	@Test
	public void testGetSecurityQuestions() throws Exception {
		Map<Integer, String> actualQuestionsResult = systemUserDao.getSecurityQuestions();
		assertEquals(this.expectedQuestions, actualQuestionsResult);		
	}

}
