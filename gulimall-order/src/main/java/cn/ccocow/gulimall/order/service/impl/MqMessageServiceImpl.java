package cn.ccocow.gulimall.order.service.impl;

import cn.ccocow.gulimall.order.entity.MqMessageEntity;
import cn.ccocow.gulimall.order.mapper.MqMessageMapper;
import cn.ccocow.gulimall.order.service.IMqMessageService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class MqMessageServiceImpl extends ServiceImpl<MqMessageMapper, MqMessageEntity> implements IMqMessageService {


}