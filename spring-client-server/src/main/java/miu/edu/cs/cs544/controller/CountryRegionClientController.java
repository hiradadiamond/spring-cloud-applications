package miu.edu.cs.cs544.controller;

import miu.edu.cs.cs544.domain.CountryRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class CountryRegionClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        System.out.println("Inside the controller of client");
        if(this.discoveryClient.getInstances(applicationName)==null){
            System.out.println("Not found");
            return null;
        }
        else{
            return this.discoveryClient.getInstances(applicationName);
        }

    }

}
