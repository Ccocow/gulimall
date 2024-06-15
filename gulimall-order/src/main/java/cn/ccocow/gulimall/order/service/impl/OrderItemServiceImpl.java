package cn.ccocow.gulimall.order.service.impl;

import cn.ccocow.gulimall.order.entity.OrderItemEntity;
import cn.ccocow.gulimall.order.mapper.OrderItemMapper;
import cn.ccocow.gulimall.order.service.IOrderItemService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements IOrderItemService {


}