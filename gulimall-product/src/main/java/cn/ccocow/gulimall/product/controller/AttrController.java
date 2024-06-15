package cn.ccocow.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.product.entity.AttrEntity;
import cn.ccocow.gulimall.product.service.IAttrService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 商品属性
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:21:21
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
  @Resource
  private IAttrService attrService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<AttrEntity> res = attrService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{attrId}")
  public Result info(@PathVariable("attrId") Long attrId) {
          AttrEntity res = attrService.getById(attrId);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody AttrEntity attrEntity) {
          attrService.save(attrEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody AttrEntity attrEntity) {
          attrService.updateById(attrEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] attrIds) {
          attrService.removeByIds(Arrays.asList(attrIds));

    return Result.success();
  }

}
