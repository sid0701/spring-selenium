package com.udemy.spring.spring_selenium.kelvin.annotations;

import java.lang.annotation.*;

@Page
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Window {

    String value() default "";

}
