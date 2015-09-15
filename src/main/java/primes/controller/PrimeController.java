package primes.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import primes.domain.Result;
import primes.service.PrimeService;

@RestController
@RequestMapping(value = "/primes", method = GET)
public class PrimeController {

    @Autowired
    private PrimeService primeService;

    @RequestMapping(value = "/{initial}")
    public @ResponseBody Result primes(@PathVariable("initial") int initial) throws Exception {
        return primeService.sieveOfEratosthenes(initial);
    }

    @RequestMapping(value = "/clearCache")
    public void clearCache() throws Exception {
        primeService.clearCache();
    }

}
