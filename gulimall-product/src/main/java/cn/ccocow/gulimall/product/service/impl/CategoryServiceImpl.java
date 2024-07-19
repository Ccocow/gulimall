package cn.ccocow.gulimall.product.service.impl;

import cn.ccocow.gulimall.product.entity.CategoryEntity;
import cn.ccocow.gulimall.product.mapper.CategoryMapper;
import cn.ccocow.gulimall.product.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements ICategoryService {

  @Resource
  private CategoryMapper categoryMapper;

  @Override
  public List<CategoryEntity> listWithTree() {
    List<CategoryEntity> categoryList = categoryMapper.selectList(null);
    Map<Long, List<CategoryEntity>> childrenMap = new HashMap<>();
    // 将 categoryList 按照 parentCid 分组存储到 childrenMap 中
    categoryList.forEach(category -> {
      Long parentCid = category.getParentCid();
      if (!childrenMap.containsKey(parentCid)) {
        childrenMap.put(parentCid, categoryList.stream()
            .filter(c -> c.getParentCid() != null && c.getParentCid().equals(parentCid))
            .sorted(Comparator.comparing(c -> c.getSort() == null ? 0 : c.getSort()))
            .collect(Collectors.toList()));
      }
    });
    // 构建分类树
    List<CategoryEntity> categoryTree = categoryList.stream()
        .filter(category -> category.getCatLevel() == 1)
        .peek(category -> category.setChildren(findChildren(category.getCatId(), childrenMap)))
        .sorted(Comparator.comparing(c -> c.getSort() == null ? 0 : c.getSort()))
        .collect(Collectors.toList());

    return categoryTree;
  }

  @Override
  public void removeMenuByIds(List<Long> catIds) {
    // TODO 1.检查当前删除的菜单是否被别的地方引用
    categoryMapper.deleteByIds(catIds);
  }

  // 递归方法，根据 parentId 在 childrenMap 中查找子节点
  private List<CategoryEntity> findChildren(Long parentId, Map<Long, List<CategoryEntity>> childrenMap) {
    List<CategoryEntity> children = childrenMap.get(parentId);
    if (children != null) {
      children.forEach(child -> child.setChildren(findChildren(child.getCatId(), childrenMap)));
    }
    return children;
  }
}