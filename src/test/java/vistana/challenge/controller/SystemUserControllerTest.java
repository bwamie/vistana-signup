package vistana.challenge.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import vistana.challenge.config.StandaloneMvcTestViewResolver;
import vistana.challenge.domain.SystemUser;
import vistana.challenge.service.SystemUserService;
import vistana.challenge.service.SystemUserServiceImplTest;

@RunWith(MockitoJUnitRunner.class)
public class SystemUserControllerTest {

final static Log logger = LogFactory.getLog(SystemUserServiceImplTest.class);
private static final String TEST_USER_NAME = "testUser";

private MockMvc mockMvc;

@InjectMocks
private SystemUserController systemUserController;

private Map<Integer, String> expectedQuestions;
private Map<Integer, String> expectedThreeQuestions;


@Mock
SystemUserService systemUserService;

@Mock
SystemUser systemUser;
@Mock
HttpSession session;

@Before
public void setUp() {
	mockMvc = MockMvcBuilders.standaloneSetup(systemUserController).setViewResolvers(new StandaloneMvcTestViewResolver())
			.build();
	
	expectedQuestions = new HashMap<>();
	expectedQuestions.put(1, "What is your mother's maiden name?");
	expectedQuestions.put(2, "What is your favorite color?");
	expectedQuestions.put(3, "Who was you childhood friend?");
	expectedQuestions.put(4, "What is your favorite car?");
	expectedQuestions.put(5, "What is your favorite sport?");
	expectedQuestions.put(6, "What is your  favorite city?");
	
	expectedThreeQuestions = new HashMap<>();
	expectedThreeQuestions.put(1, "What is your mother's maiden name?");
	expectedThreeQuestions.put(2, "What is your favorite color?");
	expectedQuestions.put(6, "What is your  favorite city?");
}


	@Test
	public void getSugnupForm() throws Exception {
		mockMvc.perform(get("/signup")).andExpect(status().isOk());
	}

	@Test
	public void addUser() throws Exception {
		when(systemUserService.getAllSecurityQuestions()).thenReturn(expectedQuestions);
		when(systemUserService.getThreeSecurityQuestions()).thenReturn(expectedThreeQuestions);
		mockMvc.perform(post("/signup")).andExpect(status().isOk());
		verify(systemUserService, times(1)).getAllSecurityQuestions();
		verify(systemUserService, times(1)).getThreeSecurityQuestions();
	}

	@Test
	public void addUserSecurityQuestions() throws Exception {
		assertTrue(systemUser != null);
		when(systemUserService.getAllSecurityQuestions()).thenReturn(expectedQuestions);
		mockMvc.perform(post("/signup-qns")
				.param("username", TEST_USER_NAME)
				.param("qn1", "1")
				.param("qn2",  "2")
				.param("qn3",  "3")
				.param("ans1", "Answer 1")
				.param("ans2",  "Answer 2")
				.param("ans3",  "Answer 3")
				.sessionAttr("systemUser", systemUser)).andExpect(status().isOk());
		verify(systemUserService, times(1)).getAllSecurityQuestions();
	}

}
