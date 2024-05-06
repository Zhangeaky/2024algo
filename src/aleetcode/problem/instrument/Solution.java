package aleetcode.problem.instrument;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Solution {

    int value() default 1;

    int number() default 1;

    String name() default "";

    String link() default "";
}
