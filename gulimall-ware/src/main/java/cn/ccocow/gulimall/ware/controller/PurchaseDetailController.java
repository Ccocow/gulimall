package cn.ccocow.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.ware.entity.PurchaseDetailEntity;
import cn.ccocow.gulimall.ware.service.IPurchaseDetailService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 17:50:27
 */
@RestController
@RequestMapping("ware/purchasedetail")
public class PurchaseDetailController {
  @Resource
  private IPurchaseDetailService purchaseDetailService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<PurchaseDetailEntity> res = purchaseDetailService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          PurchaseDetailEntity res = purchaseDetailService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody PurchaseDetailEntity purchaseDetailEntity) {
          purchaseDetailService.save(purchaseDetailEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody PurchaseDetailEntity purchaseDetailEntity) {
          purchaseDetailService.updateById(purchaseDetailEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          purchaseDetailService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
