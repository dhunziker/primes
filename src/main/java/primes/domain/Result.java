package primes.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Holds the result for the /primes web service.
 */
@XmlRootElement
public final class Result {

    private int initial;

    private List<Integer> primes;

    // Default constructor required for XML marshaling
    public Result() {
    }

    public Result(int initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    @XmlAttribute
    public int getInitial() {
        return initial;
    }

    @XmlElement(name = "prime")
    public List<Integer> getPrimes() {
        return primes;
    }

}
