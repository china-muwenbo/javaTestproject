package com.dylan.multithread.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @description: jaxb 实体类
 * @author: Mr.Mu
 * @create: 2018-03-06 16:57
 **/
@XmlRootElement(name = "xml")
public class RealSubject  {
    @XmlElement(name = "Number")
    private String Number ;
    @XmlElement(name = "ID")
    private String Id;

    public static class Builder{
        private String Number;
        private String ID;

        public Builder setID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder setNumber(String Number) {
            this.Number = Number;
            return this;
        }

        public RealSubject build() {
            RealSubject realSubject = new RealSubject();
            realSubject.Id = ID;
            realSubject.Number = Number;
            return realSubject;
        }
    }

    @Override
    public String toString() {
        return "RealSubject{" +
                "Number='" + Number + '\'' +
                ", Id='" + Id + '\'' +
                '}';
    }
}