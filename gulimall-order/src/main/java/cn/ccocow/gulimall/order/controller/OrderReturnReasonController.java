package cn.ccocow.gulimall.order.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.order.entity.OrderReturnReasonEntity;
import cn.ccocow.gulimall.order.service.IOrderReturnReasonService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 退货原因
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:16:17
 */
@RestController
@RequestMapping("order/orderreturnreason")
public class OrderReturnReasonController {
  @Resource
  private IOrderReturnReasonService orderReturnReasonService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<OrderReturnReasonEntity> res = orderReturnReasonService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          OrderReturnReasonEntity res = orderReturnReasonService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody OrderReturnReasonEntity orderReturnReasonEntity) {
          orderReturnReasonService.save(orderReturnReasonEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody OrderReturnReasonEntity orderReturnReasonEntity) {
          orderReturnReasonService.updateById(orderReturnReasonEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          orderReturnReasonService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
