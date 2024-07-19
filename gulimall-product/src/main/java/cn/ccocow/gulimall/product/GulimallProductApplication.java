package cn.ccocow.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"cn.ccocow.gulimall.config", "cn.ccocow.gulimall.product"})
public class GulimallProductApplication {

  public static void main(String[] args) {
    SpringApplication.run(GulimallProductApplication.class, args);
    System.out.println("产品服务注册成功！");
  }

}
