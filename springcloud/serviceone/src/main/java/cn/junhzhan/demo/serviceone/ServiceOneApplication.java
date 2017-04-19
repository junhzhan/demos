package cn.junhzhan.demo.serviceone;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by junhzhan on 4/16/17.
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ServiceOneApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceOneApplication.class).web(true).run(args);
    }
}
