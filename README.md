# primes

## Starting the application

Start the application using Maven from the command line:

```
mvn clean spring-boot:run
```

If, for any reason, the application doesn't start, try to run it on a different port:

```
mvn clean spring-boot:run -Dserver.port=1337
```

## Access the application

When running locally, you can use the following cURL commands to access the web service:

```
# To get JSON
curl -X GET http://localhost:8090/primes/10

# To get XML
curl -X GET -H "Accept: application/xml" http://localhost:8090/primes/10
```