package com.study.springcloud.serviceconsumer.service.impl;

import com.jy.study.springcloud.serviceremote.User;
import com.study.springcloud.serviceconsumer.service.UserService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final LoadBalancerClient loadBalancerClient;

    @Override
    public User getUserById(Long id) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-service");
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/{}", User.class, id);
        return responseEntity.getBody();
    }

    @Override
    public User getUserByUsername(String username) {
        User user = new User();
        user.setPassword(username);
        user.setPassword("123456");
        return user;
    }

    public UserServiceImpl(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }
}
