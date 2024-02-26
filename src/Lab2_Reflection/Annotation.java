package Lab2_Reflection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //аннотация ставится перед методами
public @interface Annotation {
    int value() default 1;
}

