package cn.sxt.annotation.annotation01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author 黄建波
 */
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtAnnotation01 {
    String studentName() default "";
    int age() default 0;
    int id() default -1;

    String[] schools() default {"清华大学", "北京大学"};
}
