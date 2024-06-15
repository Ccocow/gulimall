package cn.ccocow.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.product.entity.SpuInfoDescEntity;
import cn.ccocow.gulimall.product.service.ISpuInfoDescService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * spu信息介绍
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:21:21
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
  @Resource
  private ISpuInfoDescService spuInfoDescService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<SpuInfoDescEntity> res = spuInfoDescService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{spuId}")
  public Result info(@PathVariable("spuId") Long spuId) {
          SpuInfoDescEntity res = spuInfoDescService.getById(spuId);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody SpuInfoDescEntity spuInfoDescEntity) {
          spuInfoDescService.save(spuInfoDescEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody SpuInfoDescEntity spuInfoDescEntity) {
          spuInfoDescService.updateById(spuInfoDescEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] spuIds) {
          spuInfoDescService.removeByIds(Arrays.asList(spuIds));

    return Result.success();
  }

}
