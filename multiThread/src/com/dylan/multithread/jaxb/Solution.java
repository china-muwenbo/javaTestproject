package com.dylan.multithread.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
/*
* xml 转换为 实体类对象，如果某个对象中某个属性的值不存在，则属性的值赋值为NULL
*   未深入分析 转换的过程
* */



public class Solution {
    public static void main(String[] args) throws JAXBException {
        String xmlInput = "<xml></xml>";
        JAXBContext jc = JAXBContext.newInstance(RealSubject.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        RealSubject realSubject = (RealSubject) unmarshaller.unmarshal(new StringReader(xmlInput));
        Marshaller ms = jc.createMarshaller();
        ms.marshal(realSubject,System.out);
        System.out.println(realSubject);
    }
 }