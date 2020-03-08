package com.company.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * 测试TreeSet的使用
 * 可以参考TestTreeMap的代码
 * @author 黄建波
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set<Integer>  set = new TreeSet<>();
        set.add(300);
        set.add(200);
        set.add(600);

        for (Integer m : set){
            System.out.println(m);
        }

        Set<Emp2> set2 = new TreeSet<>();
        set2.add(new Emp2(100,"张三",3000));
        set2.add(new Emp2(50,"李四",2000));
        set2.add(new Emp2(150,"王五",8000));
        set2.add(new Emp2(30,"赵六",3000));

        for (Emp2 m : set2){
            System.out.println(m);
        }
    }
}

class Emp2 implements Comparable<Emp2>{
    int id;
    String name;
    double salary;

    public Emp2(int id, String name, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emp2 o){
        //负数：小于 0：等于 正数：大于
        if (this.salary > o.salary){
            return 1;
        }else if (this.salary < o.salary){
            return -1;
        }else {
            if (this.id > o.id){
                return 1;
            }else if (this.id < o.id){
                return -1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Emp2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
