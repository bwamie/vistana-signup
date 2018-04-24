package vistana.challenge.controller;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

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
import vistana.challenge.dao.SystemUserDaoImpl;
import vistana.challenge.service.SystemUserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

	final static Log logger = LogFactory.getLog(MainControllerTest.class);

	private MockMvc mockMvc;

	@InjectMocks
	private MainController mainController;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(mainController).setViewResolvers(new StandaloneMvcTestViewResolver())
				.build();
	}

	@Test
	public void index() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
	@Test
	public void index2() throws Exception {
		mockMvc.perform(get("/index")).andExpect(status().isOk());
	}

	@Test
	public void home() throws Exception {
		mockMvc.perform(get("/home")).andExpect(status().isOk());
	}
	
	@Test
	public void error() throws Exception {
		mockMvc.perform(get("/error")).andExpect(status().isOk());
	}

}