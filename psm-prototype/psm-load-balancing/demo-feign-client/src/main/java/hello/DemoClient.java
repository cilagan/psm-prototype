package hello;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.nsf.psm.foundation.ember.model.EmberModel;

@FeignClient("SolicitationDataService")
interface DemoClient {
	@RequestMapping(path = "/sdsvc/fundingOps", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	EmberModel getAllFundingOpportunities();
}
