package cn.ccocow.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

  public static void main(String[] args) {
    SpringApplication.run(GulimallCouponApplication.class, args);
    System.out.println("优惠券服务注册成功！");
  }
}
