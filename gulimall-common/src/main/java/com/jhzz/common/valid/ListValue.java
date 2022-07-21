package com.jhzz.common.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/7/18
 * \* Time: 13:19
 * \* Description:
 * \
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ListValueConstrainValidator.class})
@Documented
public @interface ListValue {
    String message() default "ListValue参数出错";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    int [] values() default  {};
}
