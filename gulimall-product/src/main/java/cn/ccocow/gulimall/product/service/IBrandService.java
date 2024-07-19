package cn.ccocow.gulimall.product.service;


import cn.ccocow.gulimall.product.domain.dto.PageDto;
import cn.ccocow.gulimall.product.entity.BrandEntity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 品牌
 *
 * @author Ccocow
 * @email
 * @date 2024-06-15 17:21:21
 */
public interface IBrandService extends IService<BrandEntity> {
  IPage<BrandEntity> selectByPage(PageDto pageDto);
}

