package cn.ccocow.gulimall.order.service.impl;

import cn.ccocow.gulimall.order.entity.OrderOperateHistoryEntity;
import cn.ccocow.gulimall.order.mapper.OrderOperateHistoryMapper;
import cn.ccocow.gulimall.order.service.IOrderOperateHistoryService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistoryEntity> implements IOrderOperateHistoryService {


}