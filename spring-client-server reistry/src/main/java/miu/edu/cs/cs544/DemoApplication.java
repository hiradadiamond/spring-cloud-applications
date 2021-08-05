package miu.edu.cs.cs544;

import miu.edu.cs.cs544.controller.CountryRegionClientController;
import miu.edu.cs.cs544.domain.CountryRegion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		CountryRegionClientController controller = context.getBean(CountryRegionClientController.class);
		CountryRegion countryRegion = controller.findById("AF");
		System.out.println(countryRegion);

		List<CountryRegion> countries = controller.findAll();
		countries.forEach(System.out::println);

//		Country country = client.findById("GE");
//
//		System.out.println(country);
//
//		List<Country> countries = client.findAll();
//		countries.forEach(System.out::println);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
