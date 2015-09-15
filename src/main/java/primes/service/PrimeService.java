package primes.service;

import primes.domain.Result;

public interface PrimeService {

	/**
	 * Calculates prime numbers up to the initial value provided.
	 *
	 * @param initial
	 * @return the result of the calculation
	 */
	Result sieveOfEratosthenes(int initial);

	// TODO Add more complex methods like the Sieve of Sundaram or Sieve of Atkin

}
