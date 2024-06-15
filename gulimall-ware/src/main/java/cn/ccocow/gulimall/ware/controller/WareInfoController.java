package cn.ccocow.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.ware.entity.WareInfoEntity;
import cn.ccocow.gulimall.ware.service.IWareInfoService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 仓库信息
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:50:27
 */
@RestController
@RequestMapping("ware/wareinfo")
public class WareInfoController {
  @Resource
  private IWareInfoService wareInfoService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<WareInfoEntity> res = wareInfoService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          WareInfoEntity res = wareInfoService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody WareInfoEntity wareInfoEntity) {
          wareInfoService.save(wareInfoEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody WareInfoEntity wareInfoEntity) {
          wareInfoService.updateById(wareInfoEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          wareInfoService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
