package cn.ccocow.gulimall.valid.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
  private Set<Integer> set = new HashSet<>();

  // 初始化方法
  @Override
  public void initialize(ListValue constraintAnnotation) {
    int[] values = constraintAnnotation.values();
    for (int value : values) {
      set.add(value);
    }
  }

  /**
   * @param value   需要校验的值
   * @param context
   * @return
   */
  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    return set.contains(value);
  }
}
