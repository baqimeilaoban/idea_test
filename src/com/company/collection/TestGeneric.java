package com.company.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ≤‚ ‘∑∫–Õ
 * @author ª∆Ω®≤®
 */
public class TestGeneric {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<>();
        mc.set("ª∆Ω®≤®",0);
        //mc.set(8888,1); ±®¥Ì

        //Integer a = (int)mc.get(1); ±®¥Ì
        String str = mc.get(0);
        System.out.println(str);

        List list = new ArrayList();
        Map map = new HashMap();
    }
}

class MyCollection<E>{
    Object[] objs = new Object[5];

    public void set(E e, int index){
        objs[index] = e;
    }

    public E get(int index){
        return (E) objs[index];
    }
}