package cn.ccocow.gulimall.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {
    "cn.ccocow.gulimall.coupon.mapper",
    "cn.ccocow.gulimall.member.mapper",
    "cn.ccocow.gulimall.order.mapper",
    "cn.ccocow.gulimall.product.mapper",
    "cn.ccocow.gulimall.ware.mapper",
})
public class MybatisPlusConfig {
  private static final Logger logger = LoggerFactory.getLogger(MybatisPlusConfig.class);

  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    logger.info("MybatisPlusConfig 初始化成功!");
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor()); // 如果配置多个插件, 切记分页最后添加
    // 如果有多数据源可以不配具体类型, 否则都建议配上具体的 DbType
    return interceptor;
  }
}
