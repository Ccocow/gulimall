package cn.ccocow.gulimall.thirdparty.service.impl;

import cn.ccocow.gulimall.thirdparty.config.OssConfig;
import cn.ccocow.gulimall.thirdparty.service.IOssService;
import cn.hutool.core.lang.UUID;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class OssServiceImpl implements IOssService {

  @Resource
  private OSS ossClient;

  @Resource
  private OssConfig ossConfig;

  @Override
  public Map<String, String> policy() {
    Map<String, String> response = new HashMap<>();
    try {
      long expireEndTime = System.currentTimeMillis() + ossConfig.getExpireTime() * 1000;
      Date expiration = new Date(expireEndTime);
      PolicyConditions policyConds = new PolicyConditions();
      policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
      policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, ossConfig.getDir());
      String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
      byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
      String encodedPolicy = BinaryUtil.toBase64String(binaryData);
      String postSignature = ossClient.calculatePostSignature(postPolicy);
      response.put("ossAccessKeyId", ossConfig.getAccessKeyId());
      response.put("policy", encodedPolicy);
      response.put("signature", postSignature);
      response.put("dir", ossConfig.getDir());
      response.put("host", ossConfig.getHost());
      response.put("fileName", UUID.randomUUID().toString().replace("-", "") + ".jpg");
    } catch (OSSException oe) {
      System.out.println("捕获一个OSSException，这意味着您的请求已发送到OSS，但由于某种原因被拒绝，并出现错误响应。");
      // 假设此方法存在
      System.out.println("HTTP Status Code: " + oe.getRawResponseError());
      System.out.println("Error Message: " + oe.getErrorMessage());
      System.out.println("Error Code:       " + oe.getErrorCode());
      System.out.println("Request ID:      " + oe.getRequestId());
      System.out.println("Host ID:           " + oe.getHostId());
    } catch (ClientException ce) {
      System.out.println("捕获了一个ClientException，这意味着客户端在试图与OSS通信时遇到了严重的内部问题，例如无法访问网络。");
      System.out.println("Error Message: " + ce.getMessage());
    } finally {
      if (ossClient != null) {
        ossClient.shutdown();
      }
    }
    return response;
  }
}