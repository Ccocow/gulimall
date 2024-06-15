package cn.ccocow.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.member.entity.GrowthChangeHistoryEntity;
import cn.ccocow.gulimall.member.service.IGrowthChangeHistoryService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 成长值变化历史记录
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:03:13
 */
@RestController
@RequestMapping("member/growthchangehistory")
public class GrowthChangeHistoryController {
  @Resource
  private IGrowthChangeHistoryService growthChangeHistoryService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<GrowthChangeHistoryEntity> res = growthChangeHistoryService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          GrowthChangeHistoryEntity res = growthChangeHistoryService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody GrowthChangeHistoryEntity growthChangeHistoryEntity) {
          growthChangeHistoryService.save(growthChangeHistoryEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody GrowthChangeHistoryEntity growthChangeHistoryEntity) {
          growthChangeHistoryService.updateById(growthChangeHistoryEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          growthChangeHistoryService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
