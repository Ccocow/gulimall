package cn.ccocow.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.coupon.entity.CouponSpuRelationEntity;
import cn.ccocow.gulimall.coupon.service.ICouponSpuRelationService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 优惠券与产品关联
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:12:03
 */
@RestController
@RequestMapping("coupon/couponspurelation")
public class CouponSpuRelationController {
  @Resource
  private ICouponSpuRelationService couponSpuRelationService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<CouponSpuRelationEntity> res = couponSpuRelationService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          CouponSpuRelationEntity res = couponSpuRelationService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody CouponSpuRelationEntity couponSpuRelationEntity) {
          couponSpuRelationService.save(couponSpuRelationEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody CouponSpuRelationEntity couponSpuRelationEntity) {
          couponSpuRelationService.updateById(couponSpuRelationEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          couponSpuRelationService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
