package com.example.demo.annotations;

import java.lang.annotation.*;

/**
 * @author admin
 * @date 2018-8-31 14:06
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String value() default "";
}
