package cn.ccocow.gulimall.coupon.controller;

import cn.ccocow.gulimall.coupon.entity.CouponEntity;
import cn.ccocow.gulimall.coupon.service.ICouponService;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 优惠券信息
 *
 * @author Ccocow
 * @email
 * @date 2024-06-15 18:12:03
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
  @Resource
  private ICouponService couponService;

  // 测试
  @GetMapping("/member/list")
  public Result<List<CouponEntity>> memberCouponList() {
    CouponEntity couponEntity = new CouponEntity();
    couponEntity.setCouponName("满100减10");
    ArrayList<CouponEntity> couponEntities = new ArrayList<>();
    couponEntities.add(couponEntity);
    return Result.success(couponEntities);
  }


  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<CouponEntity> res = couponService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
    CouponEntity res = couponService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody CouponEntity couponEntity) {
    couponService.save(couponEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody CouponEntity couponEntity) {
    couponService.updateById(couponEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
    couponService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
