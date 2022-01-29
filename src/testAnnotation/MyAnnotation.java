package testAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * 自定义的注解
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})  //可以用来指明MyAnnotation都用来修饰哪些结构
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {
    String value() default "hello";
}
