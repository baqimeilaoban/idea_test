package cn.sxt.annotation.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ����javassist��api
 * @author thinkpad
 */
public class Demo02 {
    /**
     * ������Ļ����÷�
     * @throws Exception
     */
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc= pool.get("cn.sxt.annotation.javassist.Emp");
        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        //��ȡ����
        System.out.println(cc.getName());
        //��ȡ��Ҫ����
        System.out.println(cc.getSimpleName());
        //��ȡ����
        System.out.println(cc.getSuperclass());
        //��ýӿ�
        System.out.println(cc.getInterfaces());
    }

    /**
     * ���Բ����µķ���
     * @throws Exception
     */
    public static void test02() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.sxt.annotation.javassist.Emp");
        CtMethod m = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"www.sxt.xn\");return $1+$2;}");
        cc.addMethod(m);
        //ͨ��������������ɵķ���
        Class clazz = cc.toClass();
        //ͨ������Emp�޲ι������������µ�Emp����
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("add",int.class,int.class);
        Object result = method.invoke(obj,200,300);
        System.out.println(result);
    }

    /**
     * �޸����еķ�������Ϣ���޸ķ����������
     * @throws Exception
     */
    public static void test03() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.sxt.annotation.javassist.Emp");
        CtMethod cm = cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
        cm.insertAt(32,"int b=3;System.out.println(\"b=\"+b);");
        cm.insertAfter("System.out.println(\"end!!!\");");
        //ͨ��������������ɵķ���
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sayHello",int.class);
        method.invoke(obj,300);
    }

    /**
     * ���Բ���
     * @throws Exception
     */
    public static void test04() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.sxt.annotation.javassist.Emp");
        CtField f1 = new CtField(CtClass.intType,"salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1);
        //������Ӧ��set��get����
        cc.addMethod(CtNewMethod.getter("getSalary",f1));
        cc.addMethod(CtNewMethod.setter("setSalary",f1));
    }

    /**
     * ���췽���Ĳ���
     * @throws Exception
     */
    public static void test05() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.sxt.annotation.javassist.Emp");
        CtConstructor[] cs = cc.getConstructors();
        for (CtConstructor c:
             cs) {
            System.out.println(c.getLongName());
        }
    }

    public static void test06() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.sxt.annotation.javassist.Emp");
        Object[] all = cc.getAnnotations();
        Author a = (Author)all[0];
        String name = a.name();
        int year = a.year();
        System.out.println("name: " + name + " year: " + year);
    }
    public static void main(String[] args) throws Exception {
        test06();
    }
}
