package cn.ccocow.gulimall.valid.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = {ListValueConstraintValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListValue {
  String message() default "{cn.ccocow.gulimall.valid.annotation.ListValue.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  int[] values() default {};
}
