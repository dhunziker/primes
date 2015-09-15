package primes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableCaching
public class TomcatApplication extends WebMvcConfigurerAdapter {

    @Bean
    public CacheManager cacheManager() {
        // Used for very crude caching of service calls
        return new ConcurrentMapCacheManager();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer//.favorPathExtension(false).favorParameter(false).ignoreAcceptHeader(false)
                .defaultContentType(MediaType.APPLICATION_JSON);
//                .mediaType("xml", MediaType.APPLICATION_XML)
//                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    public static void main(String[] args) {
        SpringApplication.run(TomcatApplication.class, args);
    }

}
