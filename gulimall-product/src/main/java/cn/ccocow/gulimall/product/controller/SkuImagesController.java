package cn.ccocow.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.product.entity.SkuImagesEntity;
import cn.ccocow.gulimall.product.service.ISkuImagesService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * sku图片
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:21:21
 */
@RestController
@RequestMapping("product/skuimages")
public class SkuImagesController {
  @Resource
  private ISkuImagesService skuImagesService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<SkuImagesEntity> res = skuImagesService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          SkuImagesEntity res = skuImagesService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody SkuImagesEntity skuImagesEntity) {
          skuImagesService.save(skuImagesEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody SkuImagesEntity skuImagesEntity) {
          skuImagesService.updateById(skuImagesEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          skuImagesService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
