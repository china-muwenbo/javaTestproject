package com.dylan.anno.feildAnno.useanno;

import static com.dylan.anno.feildAnno.annoutils.FruitInfoUtil.getFruitInfo;

/**
 * 输出结果
 */
public class FruitRun {
    //属性注解
    public static void main(String[] args) {
        getFruitInfo(Apple.class);
    }
}