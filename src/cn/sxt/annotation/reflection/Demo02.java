package cn.sxt.annotation.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息（类的名字，属性，方法，构造器等）
 * @author 黄建波
 */
public class Demo02 {

    public static void main(String[] args) {
        String path = "cn.sxt.annotation.reflection.bean.User";
        try {
            Class clazz = Class.forName(path);

            //获取类的名字
            //获得包名+类名
            System.out.println(clazz.getName());
            //获得类名
            System.out.println(clazz.getSimpleName());
            System.out.println("------------");

            //获取属性信息
            //只能获得public的field，不能获得private
            Field[] field = clazz.getFields();
            System.out.println(field.length);
            System.out.println("-------------");
            //获得所有的field
            Field[] fields = clazz.getDeclaredFields();
            System.out.println(fields.length);
            Field f = clazz.getDeclaredField("uname");
            for (Field temp:fields){
                System.out.println("属性：" + temp);
            }
            System.out.println("--------------");
            //获取方法的信息
            Method[] methods = clazz.getDeclaredMethods();
            Method m01 = clazz.getDeclaredMethod("getUname",null);
            //如果方法有参，则必须传递参数类型对应的class对象
            Method m02 = clazz.getDeclaredMethod("setUname", String.class);
            for (Method m:methods) {
                System.out.println("方法：" + m);
            }
            System.out.println("--------------");
            //获得构造器的信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            Constructor c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            System.out.println("获得构造器：" + c);
            for (Constructor temp:constructors) {
                System.out.println("构造器：" + temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
