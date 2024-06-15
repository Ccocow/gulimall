package cn.ccocow.gulimall.order.service.impl;

import cn.ccocow.gulimall.order.entity.PaymentInfoEntity;
import cn.ccocow.gulimall.order.mapper.PaymentInfoMapper;
import cn.ccocow.gulimall.order.service.IPaymentInfoService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfoEntity> implements IPaymentInfoService {


}