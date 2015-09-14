package primes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import primes.service.PrimeService;

@RestController
public class PrimeController {

	@Autowired
	private PrimeService primeService;

}
