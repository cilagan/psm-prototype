package gov.nsf.research.psm.rules.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import gov.nsf.research.psm.rules.service.ProposalRulesService;
import gov.nsf.research.psm.rules.service.impl.ProposalRulesServiceImpl;

@Configuration
public class AppConfig {

	/**
	 * CORS support
	 *
	 */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }
        };
    }
    
    @Bean
    public ProposalRulesService proposalRulesService(){
    	return new ProposalRulesServiceImpl();
    }

}
