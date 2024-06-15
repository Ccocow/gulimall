package cn.ccocow.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.product.entity.AttrAttrgroupRelationEntity;
import cn.ccocow.gulimall.product.service.IAttrAttrgroupRelationService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 属性&属性分组关联
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:21:21
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
  @Resource
  private IAttrAttrgroupRelationService attrAttrgroupRelationService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<AttrAttrgroupRelationEntity> res = attrAttrgroupRelationService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          AttrAttrgroupRelationEntity res = attrAttrgroupRelationService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelationEntity) {
          attrAttrgroupRelationService.save(attrAttrgroupRelationEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelationEntity) {
          attrAttrgroupRelationService.updateById(attrAttrgroupRelationEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          attrAttrgroupRelationService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
