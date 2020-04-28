package cn.sxt.annotation.reflection;

import cn.sxt.annotation.reflection.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ͨ������API��̬�Ĳ�����������������������
 * @author �ƽ���
 */
public class Demo03 {
    public static void main(String[] args) {
        String path = "cn.sxt.annotation.reflection.bean.User";
        try {
            Class<User> clazz = (Class<User>) Class.forName(path);
            //ͨ������API���ù��췽�����������
            //��ʵ�ǵ�����User���޲ι��췽��
            User u = clazz.newInstance();
            System.out.println(u);
            System.out.println("-----------");
            //ָ�����������е���
            Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2 = c.newInstance(1001,18,"�ƽ�����");
            System.out.println(u2.getUname());
            System.out.println("-----------");
            //ͨ������API������ͨ����
            User u3 = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3,"�ƽ�����");
            System.out.println(u3.getUname());
            System.out.println("-----------");
            //ͨ������API��������
            User u4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("uname");
            //������Բ���Ҫ����ȫ��飬����ֱ�ӷ���
            f.setAccessible(true);
            //ͨ������ֱ��д����
            f.set(u4,"�ƽ���4");
            //ͨ������ֱ�Ӷ����Ե�ֵ
            System.out.println(u4.getUname());
            System.out.println(u4);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
