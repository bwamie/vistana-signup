package vistana.challenge.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import vistana.challenge.config.StandaloneMvcTestViewResolver;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	private static final String TEST_USER_NAME = "testUser";

	final static Log logger = LogFactory.getLog(LoginControllerTest.class);

	private MockMvc mockMvc;

	@InjectMocks
	private LoginController loginController;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).setViewResolvers(new StandaloneMvcTestViewResolver())
				.build();
	}

	@Test
	public void login() throws Exception {
		mockMvc.perform(get("/login")).andExpect(status().isOk());
	}

	@Test
	public void loginPost() throws Exception {
		mockMvc.perform(post("/login").param("username", TEST_USER_NAME)).andExpect(status().isOk());
	}

	@Test
	public void loginRequestQnsPost() throws Exception {
		mockMvc.perform(post("/login-qns").param("username", TEST_USER_NAME)).andExpect(status().isOk());
	}

	@Test
	public void logout() throws Exception {
		mockMvc.perform(get("/logout")).andExpect(status().isOk());
	}
	
	@Test
	public void resetAccount() throws Exception {
		mockMvc.perform(get("/reset-account")).andExpect(status().isOk());
	}

}
