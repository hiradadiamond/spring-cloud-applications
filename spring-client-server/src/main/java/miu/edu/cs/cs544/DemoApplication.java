package miu.edu.cs.cs544;

import miu.edu.cs.cs544.controller.CountryRegionClientController;
import miu.edu.cs.cs544.domain.CountryRegion;
import miu.edu.cs.cs544.service.CountryRegionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableCircuitBreaker
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		CountryRegionService service = context.getBean(CountryRegionService.class);
		CountryRegion countryRegion = service.findById("AF");
		System.out.println(countryRegion);
		List<CountryRegion> countries = service.findAll();
		countries.forEach(System.out::println);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
