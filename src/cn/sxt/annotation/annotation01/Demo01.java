package cn.sxt.annotation.annotation01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ��������ע����÷�
 * @author �ƽ���
 */
@SuppressWarnings("all")
public class Demo01 {
    @Override
    public String toString() {
        return "";
    }

    @Deprecated
    public static void test01(){
        System.out.println("test01");
    }

    public static void test02(){
        List list = new ArrayList();
        List list2 = new ArrayList();
    }

    public static void main(String[] args) {
        Date d = new Date();
        test01();
    }
}
