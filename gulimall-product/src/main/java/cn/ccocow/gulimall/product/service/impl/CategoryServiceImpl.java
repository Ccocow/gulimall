package cn.ccocow.gulimall.product.service.impl;

import cn.ccocow.gulimall.product.entity.CategoryEntity;
import cn.ccocow.gulimall.product.mapper.CategoryMapper;
import cn.ccocow.gulimall.product.service.ICategoryService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements ICategoryService {


}