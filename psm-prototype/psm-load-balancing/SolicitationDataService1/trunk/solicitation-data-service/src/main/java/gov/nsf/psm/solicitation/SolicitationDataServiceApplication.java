package gov.nsf.psm.solicitation;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableEurekaClient
public class SolicitationDataServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SolicitationDataServiceApplication.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SolicitationDataServiceApplication.class, args);
    }
    
}
