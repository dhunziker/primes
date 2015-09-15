package primes;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import primes.service.PrimeService;

@Configuration
@Import(TomcatApplication.class)
public class WebTestConfig {

	@Bean
	public PrimeService primeService() {
		return mock(PrimeService.class);
	}

}
