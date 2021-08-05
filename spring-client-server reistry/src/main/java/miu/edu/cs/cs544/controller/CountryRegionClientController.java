package miu.edu.cs.cs544.controller;

import miu.edu.cs.cs544.domain.CountryRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class CountryRegionClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${base-service-url}")
    private String baseUrl;

    public CountryRegion findById(String countryCode) {
        System.out.println(baseUrl+ "url");
        String url = baseUrl + "/countries/" + countryCode;
        return restTemplate
                .getForObject(url,
                        CountryRegion.class);
    }

    public List<CountryRegion> findAll() {
        CountryRegion[] countries = restTemplate
                .getForObject(baseUrl + "/countries",
                        CountryRegion[].class);

        return Arrays.asList(countries);
    }
}
