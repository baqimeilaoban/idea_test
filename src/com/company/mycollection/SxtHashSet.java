package com.company.mycollection;

import java.util.HashMap;

/**
 * 手动实现一个HashSet，更深刻理解HashSet的底层原理
 * @author 黄建波
 */
public class SxtHashSet {
    HashMap map;
    private static final Object PRRESENT = new Object();

    public SxtHashSet(){
        map = new HashMap();
    }

    public int size(){
        return map.size();
    }

    public void add(Object o){
        map.put(o,PRRESENT);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object key:map.keySet()){
            sb.append(key + ",");
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtHashSet set = new SxtHashSet();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        System.out.println(set);
    }
}
