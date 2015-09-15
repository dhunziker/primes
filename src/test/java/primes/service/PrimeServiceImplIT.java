package primes.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import primes.TomcatApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TomcatApplication.class)
public class PrimeServiceImplIT {

    @Autowired
    private PrimeService primeService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void should_cache_repeated_calls() throws Exception {
        Cache cache = cacheManager.getCache("eratosthenes");
        assertNull(cache.get(2));

        // Populate the cache once
        primeService.sieveOfEratosthenes(2);

        assertNotNull(cache.get(2));

        // Clear the cache before calling /primes one more time
        primeService.clearCache();

        assertNull(cache.get(2));
    }

}
