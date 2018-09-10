package com.example.demo.annotations;

import java.lang.annotation.*;

/**
 * @author admin
 * @date 2018-8-31 13:44
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {

    String value() default "";
}
