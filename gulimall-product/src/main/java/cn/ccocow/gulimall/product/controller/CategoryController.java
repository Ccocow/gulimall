package cn.ccocow.gulimall.product.controller;

import cn.ccocow.gulimall.product.entity.CategoryEntity;
import cn.ccocow.gulimall.product.service.ICategoryService;
import cn.ccocow.gulimall.result.Result;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 商品三级分类
 *
 * @author Ccocow
 * @email
 * @date 2024-06-15 17:21:21
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
  @Resource
  private ICategoryService categoryService;

  /**
   * 查出所有分类和子分类
   */
  @GetMapping("/getTree")
  public Result<List<CategoryEntity>> list() {
    List<CategoryEntity> res = categoryService.listWithTree();
    return Result.success(res);
  }

  /**
   * 信息
   */
  @GetMapping("/info/{catId}")
  public Result info(@PathVariable("catId") Long catId) {
    CategoryEntity res = categoryService.getById(catId);

    return Result.success(res);
  }

  /**
   * 添加
   */
  @PostMapping("")
  public Result save(@RequestBody CategoryEntity categoryEntity) {
    categoryEntity.setSort(0);
    categoryEntity.setShowStatus(1);
    categoryService.save(categoryEntity);
    return Result.success();
  }

  /**
   * 批量修改排序
   */
  @PutMapping("/sort")
  public Result updateSort(@RequestBody CategoryEntity[] categoryEntity) {
    categoryService.updateBatchById(Arrays.asList(categoryEntity));
    return Result.success();
  }

  /**
   * 修改
   */
  @PutMapping("")
  public Result update(@RequestBody CategoryEntity categoryEntity) {
    categoryService.updateById(categoryEntity);
    return Result.success();
  }

  /**
   * 删除
   */
  @DeleteMapping("")
  public Result delete(@RequestBody Long[] catIds) {
    categoryService.removeMenuByIds(Arrays.asList(catIds));
    return Result.success();
  }

}
