package com.example.demo.annotations;

import java.lang.annotation.*;

/**
 * @author admin
 * @date 2018-8-31 13:47
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Quatifier {
    String value() default "";
}
