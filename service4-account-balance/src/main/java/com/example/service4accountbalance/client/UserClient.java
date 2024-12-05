package com.example.service4accountbalance.client;

import com.example.service4accountbalance.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service3-user-management") // S3 服务的名字，与 Eureka 注册的名字一致
public interface UserClient {

    @GetMapping("/api/users/{id}") // 对应 S3 服务的用户查询接口路径
    User getUserById(@PathVariable("id") String id);
}