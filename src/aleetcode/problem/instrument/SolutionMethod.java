package aleetcode.problem.instrument;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SolutionMethod {

    String description() default "";
    int number() default 0;

    /**
     * 方法的标识符 用于标记一道题目的一次解法
     */
    String value() default  "";
}
