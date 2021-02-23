package com.dzzdsj.design.pattern.demo.DesignPatternRunoobDemo.IteratorPattern;

//定义迭代器接口，定义方法，hasNext、 next
public interface Iterator {
    boolean hasNext();

    Object next();
}