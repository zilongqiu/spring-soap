# Basic SOAP Service

Exercice 12 - https://spring.io/guides/gs/producing-web-service/

## Commands

- `./mvnw spring-boot:run` to run
- `./mvnw clean package` to build and then `java -jar target/spring-soap-0.0.1-SNAPSHOT.jar --server.port=8080`
- Test by calling (or use SoapUI)
```
# Use data from file (request.xml)
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws
```

- or call using inline XML method
```
# Use inline XML data
curl <<-EOF -fsSL -H "content-type: text/xml" -d @- http://localhost:8080/ws \
  > target/response.xml && xmllint --format target/response.xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                                  xmlns:gs="http://localhost:8080/soap-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getCountryRequest>
         <gs:name>Spain</gs:name>
      </gs:getCountryRequest>
```

***Expected Response***
```
<?xml version="1.0"?>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
  <SOAP-ENV:Header/>
  <SOAP-ENV:Body>
    <ns2:getCountryResponse xmlns:ns2="http://spring.io/guides/gs-producing-web-service">
      <ns2:country>
        <ns2:name>Spain</ns2:name>
        <ns2:population>46704314</ns2:population>
        <ns2:capital>Madrid</ns2:capital>
        <ns2:currency>EUR</ns2:currency>
      </ns2:country>
    </ns2:getCountryResponse>
  </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```