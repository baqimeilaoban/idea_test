package cn.sxt.annotation.reflection;

import cn.sxt.annotation.reflection.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作；构造器、方法、属性
 * @author 黄建波
 */
public class Demo03 {
    public static void main(String[] args) {
        String path = "cn.sxt.annotation.reflection.bean.User";
        try {
            Class<User> clazz = (Class<User>) Class.forName(path);
            //通过反射API调用构造方法，构造对象
            //其实是调用了User的无参构造方法
            User u = clazz.newInstance();
            System.out.println(u);
            System.out.println("-----------");
            //指定构造器进行调用
            Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2 = c.newInstance(1001,18,"黄建波二");
            System.out.println(u2.getUname());
            System.out.println("-----------");
            //通过反射API调用普通方法
            User u3 = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3,"黄建波三");
            System.out.println(u3.getUname());
            System.out.println("-----------");
            //通过反射API操作属性
            User u4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("uname");
            //这个属性不需要做安全检查，可以直接访问
            f.setAccessible(true);
            //通过反射直接写属性
            f.set(u4,"黄建波4");
            //通过反射直接读属性的值
            System.out.println(u4.getUname());
            System.out.println(u4);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
