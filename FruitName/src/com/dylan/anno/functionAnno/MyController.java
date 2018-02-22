package com.dylan.anno.functionAnno;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD,METHOD})
@Retention(RUNTIME)
@Documented
public @interface MyController {
   String   name() default "default";
}
