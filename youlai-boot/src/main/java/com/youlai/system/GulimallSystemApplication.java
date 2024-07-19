package com.youlai.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@ConfigurationPropertiesScan
public class GulimallSystemApplication {
  public static void main(String[] args) {
    SpringApplication.run(GulimallSystemApplication.class, args);
    System.out.println("管理服务启动成功！");
  }
}
