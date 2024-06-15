package cn.ccocow.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.coupon.entity.SeckillSkuNoticeEntity;
import cn.ccocow.gulimall.coupon.service.ISeckillSkuNoticeService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 秒杀商品通知订阅
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:12:03
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {
  @Resource
  private ISeckillSkuNoticeService seckillSkuNoticeService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<SeckillSkuNoticeEntity> res = seckillSkuNoticeService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          SeckillSkuNoticeEntity res = seckillSkuNoticeService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody SeckillSkuNoticeEntity seckillSkuNoticeEntity) {
          seckillSkuNoticeService.save(seckillSkuNoticeEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody SeckillSkuNoticeEntity seckillSkuNoticeEntity) {
          seckillSkuNoticeService.updateById(seckillSkuNoticeEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          seckillSkuNoticeService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
