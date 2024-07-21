package cn.ccocow.gulimall.product.controller;

import cn.ccocow.gulimall.product.domain.dto.PageDto;
import cn.ccocow.gulimall.product.entity.AttrGroupEntity;
import cn.ccocow.gulimall.product.service.IAttrGroupService;
import cn.ccocow.gulimall.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


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
  @PostMapping("/page")
  public Result<IPage<AttrGroupEntity>> page(@RequestBody PageDto pageDto) {
    IPage<AttrGroupEntity> attrGroupEntityIPage = attrGroupService.selectByPage(pageDto);
    return Result.success(attrGroupEntityIPage);
  }


  /**
   * 信息
   */
  @GetMapping("/{attrGroupId}")
  public Result info(@PathVariable("attrGroupId") Long attrGroupId) {
    AttrGroupEntity res = attrGroupService.getById(attrGroupId);

    return Result.success(res);
  }

  /**
   * 添加
   */
  @PostMapping("")
  public Result save(@RequestBody AttrGroupEntity attrGroupEntity) {
    attrGroupService.save(attrGroupEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PutMapping("")
  public Result update(@RequestBody AttrGroupEntity attrGroupEntity) {
    attrGroupService.updateById(attrGroupEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @DeleteMapping("")
  public Result delete(@RequestBody Long[] attrGroupIds) {
    attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

    return Result.success();
  }

}
