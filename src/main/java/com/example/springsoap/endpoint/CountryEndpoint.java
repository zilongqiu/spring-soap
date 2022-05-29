package com.example.springsoap.endpoint;

import com.example.springsoap.repository.CountryRepository;
import localhost._8080.soap_service.GetCountryResponse;
import localhost._8080.soap_service.GetCountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/soap-service";

    @Autowired
    private CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        System.out.println(request.getName());
        response.setCountry(countryRepository.getCountryByName(request.getName()));
        System.out.println(countryRepository.getCountryByName(request.getName()));

        return response;
    }
}
