package vistana.challenge.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import vistana.challenge.controller.MainController;
import vistana.challenge.dao.SystemUserDao;
import vistana.challenge.dao.SystemUserDaoImpl;

public class SystemUserServiceImplTest {

	private final static Log logger = LogFactory.getLog(SystemUserServiceImplTest.class);
	
	private Map<Integer, String> expectedQuestions;
	
	@Mock
	SystemUserDao systemUserDao;
	SystemUserServiceImpl systemUserService;

	@Before
	public void setupMock() {
		logger.debug("Initalizing SystemUserServiceImplTest mocks");
		this.expectedQuestions = new HashMap<>();
		this.expectedQuestions.put(1, "What is your mother's maiden name?");
		this.expectedQuestions.put(2, "What is your favorite color?");
		this.expectedQuestions.put(3, "Who was you childhood friend?");
		this.expectedQuestions.put(4, "What is your favorite car?");
		this.expectedQuestions.put(5, "What is your favorite sport?");
		this.expectedQuestions.put(6, "What is your  favorite city?");
		this.systemUserService = new SystemUserServiceImpl();
		this.systemUserDao = mock(SystemUserDaoImpl.class);
		logger.debug("Mocks initialization completed.");
	}

	@After
	public void runOnceAfterClass() {
		this.expectedQuestions = null;
	}

	@Test
	public void getThreeSecurityQuestions() {
		when(systemUserDao.getSecurityQuestions()).thenReturn(this.expectedQuestions);
		Whitebox.setInternalState(systemUserService, "systemUserDao", systemUserDao);
		assertEquals(this.expectedQuestions, systemUserService.getAllSecurityQuestions());
		verify(systemUserDao, times(1)).getSecurityQuestions();
	}

	@Test
	public void getAllSecurityQuestions() {
		when(systemUserDao.getSecurityQuestions()).thenReturn(this.expectedQuestions);
		Whitebox.setInternalState(systemUserService, "systemUserDao", systemUserDao);
		assertEquals(3, systemUserService.getThreeSecurityQuestions().size());
		verify(systemUserDao, times(1)).getSecurityQuestions();
	}

	@Test
	public void getRandomQuestions() throws Exception {
		Map<Integer, String> qns =  org.powermock.reflect.Whitebox.invokeMethod(systemUserService, "getRandomQuestions", this.expectedQuestions);
		assertEquals(3, qns.size());
	}

}
