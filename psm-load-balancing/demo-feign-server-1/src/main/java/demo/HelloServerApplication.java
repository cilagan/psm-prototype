package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class HelloServerApplication {
	
	private static Logger log = LoggerFactory.getLogger(HelloServerApplication.class);
	
	@Autowired
	DiscoveryClient client;

	@RequestMapping("/")
	public String hello() {
		log.info("Instance 1");
		ServiceInstance localInstance = client.getLocalServiceInstance();
		return "Hello World: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
	}
}