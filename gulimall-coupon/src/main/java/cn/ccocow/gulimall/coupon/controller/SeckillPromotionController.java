package cn.ccocow.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.coupon.entity.SeckillPromotionEntity;
import cn.ccocow.gulimall.coupon.service.ISeckillPromotionService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 秒杀活动
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:12:03
 */
@RestController
@RequestMapping("coupon/seckillpromotion")
public class SeckillPromotionController {
  @Resource
  private ISeckillPromotionService seckillPromotionService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<SeckillPromotionEntity> res = seckillPromotionService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          SeckillPromotionEntity res = seckillPromotionService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody SeckillPromotionEntity seckillPromotionEntity) {
          seckillPromotionService.save(seckillPromotionEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody SeckillPromotionEntity seckillPromotionEntity) {
          seckillPromotionService.updateById(seckillPromotionEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          seckillPromotionService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}