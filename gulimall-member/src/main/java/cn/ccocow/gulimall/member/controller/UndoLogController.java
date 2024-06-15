package cn.ccocow.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.member.entity.UndoLogEntity;
import cn.ccocow.gulimall.member.service.IUndoLogService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:03:13
 */
@RestController
@RequestMapping("member/undolog")
public class UndoLogController {
  @Resource
  private IUndoLogService undoLogService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<UndoLogEntity> res = undoLogService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          UndoLogEntity res = undoLogService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody UndoLogEntity undoLogEntity) {
          undoLogService.save(undoLogEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody UndoLogEntity undoLogEntity) {
          undoLogService.updateById(undoLogEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          undoLogService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
