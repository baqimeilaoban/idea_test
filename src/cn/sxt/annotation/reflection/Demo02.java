package cn.sxt.annotation.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Ӧ�÷����API����ȡ�����Ϣ��������֣����ԣ��������������ȣ�
 * @author �ƽ���
 */
public class Demo02 {

    public static void main(String[] args) {
        String path = "cn.sxt.annotation.reflection.bean.User";
        try {
            Class clazz = Class.forName(path);

            //��ȡ�������
            //��ð���+����
            System.out.println(clazz.getName());
            //�������
            System.out.println(clazz.getSimpleName());
            System.out.println("------------");

            //��ȡ������Ϣ
            //ֻ�ܻ��public��field�����ܻ��private
            Field[] field = clazz.getFields();
            System.out.println(field.length);
            System.out.println("-------------");
            //������е�field
            Field[] fields = clazz.getDeclaredFields();
            System.out.println(fields.length);
            Field f = clazz.getDeclaredField("uname");
            for (Field temp:fields){
                System.out.println("���ԣ�" + temp);
            }
            System.out.println("--------------");
            //��ȡ��������Ϣ
            Method[] methods = clazz.getDeclaredMethods();
            Method m01 = clazz.getDeclaredMethod("getUname",null);
            //��������вΣ�����봫�ݲ������Ͷ�Ӧ��class����
            Method m02 = clazz.getDeclaredMethod("setUname", String.class);
            for (Method m:methods) {
                System.out.println("������" + m);
            }
            System.out.println("--------------");
            //��ù���������Ϣ
            Constructor[] constructors = clazz.getDeclaredConstructors();
            Constructor c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            System.out.println("��ù�������" + c);
            for (Constructor temp:constructors) {
                System.out.println("��������" + temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
