package cn.ccocow.gulimall.order.service.impl;

import cn.ccocow.gulimall.order.entity.OrderEntity;
import cn.ccocow.gulimall.order.mapper.OrderMapper;
import cn.ccocow.gulimall.order.service.IOrderService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {


}