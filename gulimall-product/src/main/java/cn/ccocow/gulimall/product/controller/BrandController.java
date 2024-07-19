package cn.ccocow.gulimall.product.controller;

import cn.ccocow.gulimall.product.domain.dto.PageDto;
import cn.ccocow.gulimall.product.entity.BrandEntity;
import cn.ccocow.gulimall.product.service.IBrandService;
import cn.ccocow.gulimall.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 品牌
 *
 * @author Ccocow
 * @email
 * @date 2024-06-15 17:21:21
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
  @Resource
  private IBrandService brandService;

  /**
   * 分页查询
   */
  @PostMapping("/page")
  public Result<IPage<BrandEntity>> list(@RequestBody PageDto pageDto) {
    IPage<BrandEntity> brandEntityIPage = brandService.selectByPage(pageDto);
    return Result.success(brandEntityIPage);
  }


  /**
   * 信息
   */
  @GetMapping("/info/{brandId}")
  public Result info(@PathVariable("brandId") Long brandId) {
    BrandEntity res = brandService.getById(brandId);
    return Result.success(res);
  }

  /**
   * 保存
   */
  @PostMapping("")
  public Result save(@RequestBody BrandEntity brandEntity) {
    brandService.save(brandEntity);
    return Result.success();
  }

  /**
   * 修改
   */
  @PutMapping("")
  public Result update(@RequestBody BrandEntity brandEntity) {
    brandService.updateById(brandEntity);
    return Result.success();
  }

  /**
   * 删除
   */
  @DeleteMapping("")
  public Result delete(@RequestBody Long[] brandIds) {
    brandService.removeByIds(Arrays.asList(brandIds));
    return Result.success();
  }

}
