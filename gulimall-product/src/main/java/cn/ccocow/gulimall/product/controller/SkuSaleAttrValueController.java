package cn.ccocow.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.product.entity.SkuSaleAttrValueEntity;
import cn.ccocow.gulimall.product.service.ISkuSaleAttrValueService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * sku销售属性&值
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:21:21
 */
@RestController
@RequestMapping("product/skusaleattrvalue")
public class SkuSaleAttrValueController {
  @Resource
  private ISkuSaleAttrValueService skuSaleAttrValueService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<SkuSaleAttrValueEntity> res = skuSaleAttrValueService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          SkuSaleAttrValueEntity res = skuSaleAttrValueService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValueEntity) {
          skuSaleAttrValueService.save(skuSaleAttrValueEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValueEntity) {
          skuSaleAttrValueService.updateById(skuSaleAttrValueEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          skuSaleAttrValueService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
