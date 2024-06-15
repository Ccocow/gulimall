package cn.ccocow.gulimall.order.controller;

import java.util.Arrays;
import java.util.Map;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.order.entity.MqMessageEntity;
import cn.ccocow.gulimall.order.service.IMqMessageService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:16:17
 */
@RestController
@RequestMapping("order/mqmessage")
public class MqMessageController {
  @Resource
  private IMqMessageService mqMessageService;

  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<MqMessageEntity> res = mqMessageService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{messageId}")
  public Result info(@PathVariable("messageId") String messageId) {
          MqMessageEntity res = mqMessageService.getById(messageId);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody MqMessageEntity mqMessageEntity) {
          mqMessageService.save(mqMessageEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody MqMessageEntity mqMessageEntity) {
          mqMessageService.updateById(mqMessageEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody String[] messageIds) {
          mqMessageService.removeByIds(Arrays.asList(messageIds));

    return Result.success();
  }

}
