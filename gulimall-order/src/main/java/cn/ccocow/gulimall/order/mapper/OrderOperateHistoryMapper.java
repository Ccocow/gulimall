package cn.ccocow.gulimall.order.mapper;

import cn.ccocow.gulimall.order.entity.OrderOperateHistoryEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author Ccocow
 * @email 
 * @date 2024-06-15 18:16:17
 */
@Mapper
public interface OrderOperateHistoryMapper extends BaseMapper<OrderOperateHistoryEntity> {
	
}
