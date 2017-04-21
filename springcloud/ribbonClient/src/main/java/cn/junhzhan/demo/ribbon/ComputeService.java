package cn.junhzhan.demo.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by junhzhan on 4/21/17.
 */
@Service
public class ComputeService {

    private Logger logger = LoggerFactory.getLogger(ComputeService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForObject("http://COMPUTE-SERVICE/add?a=10&b=20", String.class);
    }


    public String addServiceFallback() {
        logger.info("addServiceFallback called");
        return "error";
    }
}
