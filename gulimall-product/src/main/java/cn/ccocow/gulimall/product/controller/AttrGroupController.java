package cn.ccocow.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.product.entity.AttrGroupEntity;
import cn.ccocow.gulimall.product.service.IAttrGroupService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 属性分组
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:21:21
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
  @Resource
  private IAttrGroupService attrGroupService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<AttrGroupEntity> res = attrGroupService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{attrGroupId}")
  public Result info(@PathVariable("attrGroupId") Long attrGroupId) {
          AttrGroupEntity res = attrGroupService.getById(attrGroupId);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody AttrGroupEntity attrGroupEntity) {
          attrGroupService.save(attrGroupEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody AttrGroupEntity attrGroupEntity) {
          attrGroupService.updateById(attrGroupEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] attrGroupIds) {
          attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

    return Result.success();
  }

}
