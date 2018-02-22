package anno;

public @interface MyAnnotation {

    String value1() default  "abc";
    String value2() default  "value2";
}