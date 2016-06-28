package gov.nsf.psm.solicitation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SolicitationDataServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SolicitationDataServiceApplication.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SolicitationDataServiceApplication.class, args);
    }
}
