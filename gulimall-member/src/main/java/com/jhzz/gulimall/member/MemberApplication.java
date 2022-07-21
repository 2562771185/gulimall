package com.jhzz.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/7/12
 * \* Time: 21:56
 * \* Description:
 * \ 远程调用别的服务
 *  1.引入open-feign
 *  2.编写一个接口，告诉SpringCloud这个接口需要调用远程服务
 *      - 声明接口的每一个方法都是调用哪个远程服务的哪个请求（完整路径）
 *  3.开启远程调用功能
 */
@EnableFeignClients(basePackages = "com.jhzz.gulimall.member.feign")
@MapperScan("com.jhzz.gulimall.member.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
