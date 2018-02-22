package com.dylan.anno.functionAnno;

public class MyTestController {
    @MyController(name = "my anno Controller ")
    public void test(){
        System.out.println("this is test method added MyController anno");
    }
    public void testNoAnno(){
        System.out.println("this is test method NO MyController anno");
    }
}
