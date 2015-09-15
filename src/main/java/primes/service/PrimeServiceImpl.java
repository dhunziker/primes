package primes.service;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import primes.domain.Result;

@Service
public class PrimeServiceImpl implements PrimeService {

	private static final Log log = LogFactory.getLog(PrimeServiceImpl.class);

	@Override
	@Cacheable("primes")
	public Result sieveOfEratosthenes(int initial) {
		log.info("Calculating primes up to " + initial);
		if (initial < 0) {
			throw new IllegalArgumentException("initial cannot be negative");
		}

		// Prepare an array of booleans indicating prime numbers
		boolean[] arr = new boolean[initial + 1];
		Arrays.fill(arr, true);

		// Mark all multiples of this loop index as not prime
		for (int i = 2; i <= (int) Math.sqrt(initial); i++) {
			if (arr[i]) {
				for (int j = i * i; j < arr.length; j += i) {
					arr[j] = false;
				}
			}
		}

		return new Result(initial, asIntList(arr));
	}

	private List<Integer> asIntList(boolean[] arr) {
		return IntStream.range(2, arr.length).filter(i -> arr[i]).boxed().collect(toList());
	}

}
