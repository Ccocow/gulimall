package cn.ccocow.gulimall.order.service.impl;

import cn.ccocow.gulimall.order.entity.UndoLogEntity;
import cn.ccocow.gulimall.order.mapper.UndoLogMapper;
import cn.ccocow.gulimall.order.service.IUndoLogService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper, UndoLogEntity> implements IUndoLogService {


}