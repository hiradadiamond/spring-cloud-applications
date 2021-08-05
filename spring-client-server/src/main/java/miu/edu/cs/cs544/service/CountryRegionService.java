package miu.edu.cs.cs544.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import miu.edu.cs.cs544.domain.CountryRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryRegionService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring-boot-server.name}")
    private String serverName;


    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public CountryRegion findById(String countryCode) {
        String url = getBaseServiceUrl() + "/countries/" + countryCode;
        return restTemplate
                .getForObject(url,
                        CountryRegion.class);
    }

    public CountryRegion findByIdFallback(String countryCode) {
        System.out.println("Inside findByIdFallback()");
        return new CountryRegion();
    }

    @HystrixCommand(fallbackMethod = "findAllFallback2")
    public List<CountryRegion> findAll() {
        CountryRegion[] countries = restTemplate
                .getForObject(getBaseServiceUrl() + "/countries",
                        CountryRegion[].class);

        return Arrays.asList(countries);
    }
    public List<CountryRegion>findAllFallback2(){
        System.out.println("Inside fallback2 method");
        return new ArrayList<>();
    }

    private String getBaseServiceUrl() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serverName);
        serviceInstances.forEach(System.out::println);
        return serviceInstances.get(0).getUri().toString();
    }
}
