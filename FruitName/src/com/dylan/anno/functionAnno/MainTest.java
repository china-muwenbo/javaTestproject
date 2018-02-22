package com.dylan.anno.functionAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MainTest {

    public static void main(String[] args) {

        Class<?> clazz=MyTestController.class;
       Method[] methods= clazz.getDeclaredMethods();
       for (Method m:methods){
            Annotation[] anoos= m.getDeclaredAnnotations();
            for(Annotation a:anoos){
                System.out.println("方法m："+m+"注解值"+((MyController)a).name());
            }
       }
    }


}
