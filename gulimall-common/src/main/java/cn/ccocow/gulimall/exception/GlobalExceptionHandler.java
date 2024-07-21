package cn.ccocow.gulimall.exception;

import cn.ccocow.gulimall.enums.BizCodeEnum;
import cn.ccocow.gulimall.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
  // 处理JSR380校验失败异常
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public Result handleValidException(MethodArgumentNotValidException e) {
    BindingResult bindingResult = e.getBindingResult();
    Map<String, String> errorMap = new HashMap<>();
    bindingResult.getFieldErrors().forEach(fieldError -> {
      errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
    });
    return Result.result(BizCodeEnum.VALID_EXCEPTION, errorMap);
  }

  @ExceptionHandler(value = Throwable.class)
  public Result handleException(Throwable throwable) {
    log.error(throwable.getMessage());
    return Result.failed(BizCodeEnum.UNKNOWN_EXCEPTION);
  }
}
