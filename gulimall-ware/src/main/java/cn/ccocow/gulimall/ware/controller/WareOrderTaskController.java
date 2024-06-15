package cn.ccocow.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.ware.entity.WareOrderTaskEntity;
import cn.ccocow.gulimall.ware.service.IWareOrderTaskService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 库存工作单
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:50:27
 */
@RestController
@RequestMapping("ware/wareordertask")
public class WareOrderTaskController {
  @Resource
  private IWareOrderTaskService wareOrderTaskService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<WareOrderTaskEntity> res = wareOrderTaskService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          WareOrderTaskEntity res = wareOrderTaskService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody WareOrderTaskEntity wareOrderTaskEntity) {
          wareOrderTaskService.save(wareOrderTaskEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody WareOrderTaskEntity wareOrderTaskEntity) {
          wareOrderTaskService.updateById(wareOrderTaskEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          wareOrderTaskService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
