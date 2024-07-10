package cn.ccocow.gulimall.member.feign;

import cn.ccocow.gulimall.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gulimall-coupon")
public interface CouponFeignService {
  @GetMapping("/coupon/coupon/member/list")
  Result memberCouponList();
}
