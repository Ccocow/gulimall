package cn.ccocow.gulimall.enums;

import cn.ccocow.gulimall.result.IResultCode;

import java.io.Serializable;

public enum BizCodeEnum implements IResultCode, Serializable {

  UNKNOWN_EXCEPTION("10000", "系统未知错误"),
  VALID_EXCEPTION("10001", "参数格式校验失败"),
  ;

  private String code;
  private String msg;

  BizCodeEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public String getMsg() {
    return msg;
  }
}
