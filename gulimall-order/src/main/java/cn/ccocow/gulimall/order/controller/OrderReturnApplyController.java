package cn.ccocow.gulimall.order.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.order.entity.OrderReturnApplyEntity;
import cn.ccocow.gulimall.order.service.IOrderReturnApplyService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 订单退货申请
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:16:17
 */
@RestController
@RequestMapping("order/orderreturnapply")
public class OrderReturnApplyController {
  @Resource
  private IOrderReturnApplyService orderReturnApplyService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<OrderReturnApplyEntity> res = orderReturnApplyService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
          OrderReturnApplyEntity res = orderReturnApplyService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody OrderReturnApplyEntity orderReturnApplyEntity) {
          orderReturnApplyService.save(orderReturnApplyEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody OrderReturnApplyEntity orderReturnApplyEntity) {
          orderReturnApplyService.updateById(orderReturnApplyEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
          orderReturnApplyService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
