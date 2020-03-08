package com.company.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * ����TreeMap��ʹ��
 * @author �ƽ���
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> treemap1 = new TreeMap<>();
        treemap1.put(20,"aa");
        treemap1.put(30,"bb");
        treemap1.put(6,"cc");

        //��װkey�����ķ�ʽ����
        for (Integer key : treemap1.keySet()){
            System.out.println(key + "---" + treemap1.get(key));
        }

        Map<Emp,String> treemap2 = new TreeMap<>();
        treemap2.put(new Emp(100,"����",50000),"������һ����С��");
        treemap2.put(new Emp(200,"����",5000),"���Ĺ���������");
        treemap2.put(new Emp(300,"����",6000),"���幤��������");
        treemap2.put(new Emp(50,"����",6000),"�����Ǹ����Ĺ�");

        //����key�������бȽ� ����key����Emp������Emp�е�CompareTo�����ȱȽ�salary�ٱȽ�id
        for (Emp key:treemap2.keySet()){
            System.out.println(key + "---" + treemap2.get(key));
        }
    }
}

class Emp implements Comparable<Emp> {
    int id;
    String name;
    double salary;

    /**
     * ��ӹ�����
     */
    public Emp (int id, String name, double salary){
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Emp o) {
        //������С�� 0������ ����������
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
}

