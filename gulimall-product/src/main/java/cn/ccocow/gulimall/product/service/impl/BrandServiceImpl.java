package cn.ccocow.gulimall.product.service.impl;

import cn.ccocow.gulimall.product.domain.dto.PageDto;
import cn.ccocow.gulimall.product.entity.BrandEntity;
import cn.ccocow.gulimall.product.mapper.BrandMapper;
import cn.ccocow.gulimall.product.service.IBrandService;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements IBrandService {

  @Resource
  private BrandMapper brandMapper;

  @Override
  public IPage<BrandEntity> selectByPage(PageDto pageDto) {
    LambdaQueryWrapper<BrandEntity> queryWrapper = new LambdaQueryWrapper<>();
    Page<BrandEntity> page = new Page<>(pageDto.getPageNum(), pageDto.getPageSize());

    // 构建查询条件
    if (pageDto.getSearch() != null && !pageDto.getSearch().isEmpty()) {
      queryWrapper.like(BrandEntity::getName, pageDto.getSearch())
          .or()
          .like(BrandEntity::getDescript, pageDto.getSearch());
    }
    IPage<BrandEntity> brandEntityIPage = brandMapper.selectPage(page, queryWrapper);
    return brandEntityIPage;
  }
}