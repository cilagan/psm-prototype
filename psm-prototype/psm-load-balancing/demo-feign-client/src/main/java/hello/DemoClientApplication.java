package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.psm.foundation.ember.model.EmberModel;
import gov.nsf.psm.foundation.model.FundingOpportunity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class DemoClientApplication extends SpringBootServletInitializer {
	
	@Autowired
	DemoClient client;

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmberModel getAllFundingOpportunities() {
		return client.getAllFundingOpportunities();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoClientApplication.class, args);
	}

}
