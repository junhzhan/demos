package cn.junhzhan.demo.serviceone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by junhzhan on 4/16/17.
 */
@RestController
public class ComputeController {


    private Logger logger = LoggerFactory.getLogger(ComputeController.class);
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();

        Integer r = a + b;

        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);

        return r;

    }
}
