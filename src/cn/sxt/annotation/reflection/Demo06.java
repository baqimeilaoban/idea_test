package cn.sxt.annotation.reflection;

import cn.sxt.annotation.reflection.bean.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过跳过安全检查，提高反射效率
 * 三种执行方法的效率差异比较
 * @author thinkpad
 */
public class Demo06 {
    public static void test01(){
        User u = new User();
        long startTime = System.currentTimeMillis();
        for (int i=0; i<1000000000L; i++){
            u.getUname();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用，执行10亿次，耗时：" + (endTime-startTime) + "ms");
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class clazz = u.getClass();
        Method m = clazz.getDeclaredMethod("getUname",null);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<1000000000L; i++){
            m.invoke(u,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，执行10亿次，耗时：" + (endTime-startTime) +"ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class clazz = u.getClass();
        Method m = clazz.getDeclaredMethod("getUname",null);
        m.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<1000000000L; i++){
            m.invoke(u,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，跳过安全检查，执行10亿次，耗时：" + (endTime-startTime) + "ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
