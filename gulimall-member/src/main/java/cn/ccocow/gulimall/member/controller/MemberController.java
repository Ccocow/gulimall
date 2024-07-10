package cn.ccocow.gulimall.member.controller;

import cn.ccocow.gulimall.member.entity.MemberEntity;
import cn.ccocow.gulimall.member.feign.CouponFeignService;
import cn.ccocow.gulimall.member.service.IMemberService;
import cn.ccocow.gulimall.result.PageResult;
import cn.ccocow.gulimall.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 会员
 *
 * @author Ccocow
 * @email
 * @date 2024-06-15 18:03:13
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
  @Resource
  private IMemberService memberService;

  @Resource
  private CouponFeignService couponFeignService;

  @GetMapping("/coupons")
  public Result test() {
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setNickname("张三");
    Result<List> listResult = couponFeignService.memberCouponList();
    listResult.getData().add("member:" + memberEntity.getNickname());
    return Result.success(listResult);
  }


  /**
   * 分页查询
   */
  @PostMapping("/list")
  public PageResult list(@RequestParam Map<String, Object> params) {
    IPage<MemberEntity> res = memberService
        .lambdaQuery()
        .page(new Page<>(Long.parseLong(params.get("pageNum").toString()), Long.parseLong(params.get("pageSize").toString())));
    return PageResult.success(res);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{id}")
  public Result info(@PathVariable("id") Long id) {
    MemberEntity res = memberService.getById(id);

    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("/save")
  public Result save(@RequestBody MemberEntity memberEntity) {
    memberService.save(memberEntity);

    return Result.success();
  }

  /**
   * 修改
   */
  @PostMapping("/update")
  public Result update(@RequestBody MemberEntity memberEntity) {
    memberService.updateById(memberEntity);

    return Result.success();
  }

  /**
   * 删除
   */
  @PostMapping("/delete")
  public Result delete(@RequestBody Long[] ids) {
    memberService.removeByIds(Arrays.asList(ids));

    return Result.success();
  }

}
