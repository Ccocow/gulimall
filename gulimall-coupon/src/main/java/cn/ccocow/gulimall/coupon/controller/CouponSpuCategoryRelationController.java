package cn.ccocow.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.coupon.entity.CouponSpuCategoryRelationEntity;
import cn.ccocow.gulimall.coupon.service.ICouponSpuCategoryRelationService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 优惠券分类关联
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:12:03
 */
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
public class CouponSpuCategoryRelationController {
  @Resource
  private ICouponSpuCategoryRelationService couponSpuCategoryRelationService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<CouponSpuCategoryRelationEntity> res = couponSpuCategoryRelationService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          CouponSpuCategoryRelationEntity res = couponSpuCategoryRelationService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelationEntity) {
          couponSpuCategoryRelationService.save(couponSpuCategoryRelationEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelationEntity) {
          couponSpuCategoryRelationService.updateById(couponSpuCategoryRelationEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          couponSpuCategoryRelationService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
