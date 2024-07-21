package cn.ccocow.gulimall.product.service.impl;

import cn.ccocow.gulimall.product.domain.dto.PageDto;
import cn.ccocow.gulimall.product.entity.AttrGroupEntity;
import cn.ccocow.gulimall.product.mapper.AttrGroupMapper;
import cn.ccocow.gulimall.product.service.IAttrGroupService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroupEntity> implements IAttrGroupService {

  @Resource
  private AttrGroupMapper attrGroupMapper;

  @Override
  public IPage<AttrGroupEntity> selectByPage(PageDto pageDto) {
    LambdaQueryWrapper<AttrGroupEntity> queryWrapper = new LambdaQueryWrapper<>();
    Page<AttrGroupEntity> page = new Page<>(pageDto.getPageNum(), pageDto.getPageSize());
    // 构建查询条件
    queryWrapper.eq(pageDto.getId() != 0, AttrGroupEntity::getCatelogId, pageDto.getId());
    if (pageDto.getSearch() != null && !pageDto.getSearch().isEmpty()) {
      queryWrapper.like(AttrGroupEntity::getAttrGroupName, pageDto.getSearch())
          .or()
          .like(AttrGroupEntity::getDescript, pageDto.getSearch());
    }
    IPage<AttrGroupEntity> attrGroupEntityIPage = attrGroupMapper.selectPage(page, queryWrapper);
    return attrGroupEntityIPage;
  }
}