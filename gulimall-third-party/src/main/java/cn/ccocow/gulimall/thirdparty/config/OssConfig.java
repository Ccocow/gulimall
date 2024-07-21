package cn.ccocow.gulimall.thirdparty.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@RefreshScope
public class OssConfig {
  /**
   * 将 <YOUR-ENDPOINT> 替换为 Endpoint，例如 oss-cn-hangzhou.aliyuncs.com
   */
  @Value("${alibaba.cloud.oss.endpoint}")
  private String endpoint;

  /**
   * 将 <YOUR-BUCKET> 替换为 Bucket 名称
   */
  @Value("${alibaba.cloud.bucket}")
  private String bucket;

  /**
   * 指定过期时间，单位为秒
   */
  private long expireTime = 3600;

  @Value("${alibaba.cloud.access-key}")
  private String accessKeyId;

  @Value("${alibaba.cloud.secret-key}")
  private String accessKeySecret;

  private OSS ossClient;

  @Bean
  public OSS getOssClient() {
    this.ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    return ossClient;
  }

  @Bean
  public String getAccessKeyId() {
    return accessKeyId;
  }

  @Bean
  public long getExpireTime() {
    return expireTime;
  }

  @Bean
  public String getDir() {
    return LocalDate.now() + "/";
  }

  @PreDestroy
  public void onDestroy() {
    if (this.ossClient != null) {
      this.ossClient.shutdown();
    }
  }
}
