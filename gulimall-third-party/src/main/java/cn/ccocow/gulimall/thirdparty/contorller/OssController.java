package cn.ccocow.gulimall.thirdparty.contorller;

import cn.ccocow.gulimall.result.Result;
import cn.ccocow.gulimall.thirdparty.service.IOssService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/thirdParty/oss")
public class OssController {
  @Resource
  IOssService ossService;

  @GetMapping("/policy")
  public Result policy() {
    Map<String, String> policy = ossService.policy();
    return Result.success(policy);
  }
}
