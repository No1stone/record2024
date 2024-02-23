package com.origemite.gateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GatewayController {

    private final DiscoveryClient discoveryClient;

    @GetMapping("/service")
    private List<String> getService(){
        return discoveryClient.getServices();
    }
    @GetMapping("/instance/{serviceName}")
    private List<ServiceInstance> getService(@PathVariable(name = "serviceName")String serviceName){
        return discoveryClient.getInstances(serviceName);
    }

}
