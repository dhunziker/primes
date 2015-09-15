package primes.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import primes.WebTestConfig;
import primes.domain.Result;
import primes.service.PrimeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebTestConfig.class)
@WebIntegrationTest
public class PrimeControllerIT {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private PrimeService primeService;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = webAppContextSetup(wac).build();
		when(primeService.sieveOfEratosthenes(10)).thenReturn(new Result(10, Arrays.asList(2, 3, 5, 7)));
	}

	@Test
	public void should_return_json_response() throws Exception {
		mockMvc.perform(get("/primes/10")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("initial").value(10)).andExpect(jsonPath("primes[0]").value(2))
				.andExpect(jsonPath("primes[1]").value(3)).andExpect(jsonPath("primes[2]").value(5))
				.andExpect(jsonPath("primes[3]").value(7));
	}

	@Test
	public void should_return_xml_response() throws Exception {
		mockMvc.perform(get("/primes/10").accept(MediaType.APPLICATION_XML)).andExpect(status().isOk())
				.andExpect(content().contentType("application/xml")).andExpect(xpath("//result/@initial").string("10"))
				.andExpect(xpath("(//prime)[1]").string("2")).andExpect(xpath("(//prime)[2]").string("3"))
				.andExpect(xpath("(//prime)[3]").string("5")).andExpect(xpath("(//prime)[4]").string("7"));
	}

	@Test
	public void should_fail_when_missing_path_variable() throws Exception {
		mockMvc.perform(get("/primes")).andExpect(status().isNotFound());
	}

}
