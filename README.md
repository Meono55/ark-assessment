# Java Spring boot API for basic investment managment using H2 embedded database
 

***presuming you have maven installed and correctly added maven to your environment variable.***

*if not this helped me set it up on my new laptop:* https://mkyong.com/maven/how-to-install-maven-in-windows/

<br>
<br>

**To run spring boot app in terminal go to root of project folder and type this command:** 
```
mvn spring-boot:run
```
**SWAGGER UI for endpoints:** http://localhost:8080/swagger-ui/

**H2 database:** http://localhost:8080/h2-ui

I tested endpoints via ***POSTMAN*** but since requirenment was to test via terminal then best way is to use *curl*

For example to get a list of current clients using default **GET HTTP METHOD CALL**: 
```
curl -v http://localhost:8080/api/clients
```

Helpful guide for making curl calls via different HTTP method calls: https://www.baeldung.com/curl-rest
<br>
<br>
Since this is using H2 I added some data at intial start of app to the database. I created a Client (named Jose) and an associated Fund and an Investor (named Shakira) to start off.
