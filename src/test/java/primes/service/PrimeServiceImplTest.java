package primes.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import primes.domain.Result;

public class PrimeServiceImplTest {

    private PrimeServiceImpl primeService;

    @Before
    public void setUp() throws Exception {
        primeService = new PrimeServiceImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_for_negative_initial() {
        primeService.sieveOfEratosthenes(-1);
    }

    @Test
    public void should_return_no_primes() {
        assertTrue(primeService.sieveOfEratosthenes(0).getPrimes().isEmpty());
        assertTrue(primeService.sieveOfEratosthenes(1).getPrimes().isEmpty());
    }

    @Test
    public void should_return_a_single_prime() {
        List<Integer> primes = Arrays.asList(2);
        Result res = primeService.sieveOfEratosthenes(2);
        assertEquals(2, res.getInitial());
        assertEquals(primes, res.getPrimes());
    }

    @Test
    public void should_generate_primes_up_to_30() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        Result res = primeService.sieveOfEratosthenes(30);
        assertEquals(30, res.getInitial());
        assertEquals(primes, res.getPrimes());
    }

    @Test
    public void should_generate_primes_up_to_120() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113);
        Result res = primeService.sieveOfEratosthenes(120);
        assertEquals(120, res.getInitial());
        assertEquals(primes, res.getPrimes());
    }

}
