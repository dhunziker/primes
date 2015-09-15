package primes.service;

import primes.domain.Result;

public interface PrimeService {

    Result sieveOfEratosthenes(int initial);

    // TODO Add more complex methods like the Sieve of Sundaram or Sieve of Atkin

    void clearCache();

}
