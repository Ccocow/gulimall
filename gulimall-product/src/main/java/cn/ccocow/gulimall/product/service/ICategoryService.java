package cn.ccocow.gulimall.product.service;


import cn.ccocow.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 商品三级分类
 *
 * @author Ccocow
 * @email
 * @date 2024-06-15 17:21:21
 */
public interface ICategoryService extends IService<CategoryEntity> {
  List<CategoryEntity> listWithTree();

  void removeMenuByIds(List<Long> catIds);
}

