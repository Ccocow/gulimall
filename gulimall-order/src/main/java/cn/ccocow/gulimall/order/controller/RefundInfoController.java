package cn.ccocow.gulimall.order.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.order.entity.RefundInfoEntity;
import cn.ccocow.gulimall.order.service.IRefundInfoService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 退款信息
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:16:17
 */
@RestController
@RequestMapping("order/refundinfo")
public class RefundInfoController {
  @Resource
  private IRefundInfoService refundInfoService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<RefundInfoEntity> res = refundInfoService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          RefundInfoEntity res = refundInfoService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody RefundInfoEntity refundInfoEntity) {
          refundInfoService.save(refundInfoEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody RefundInfoEntity refundInfoEntity) {
          refundInfoService.updateById(refundInfoEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          refundInfoService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
