package cn.sxt.annotation.javassist;

import javassist.*;

/**
 * ����ʹ��javassist����һ���µ���
 * @author thinkpad
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("cn.sxt.annotation.javassist.Emp2");

        //��������
        CtField f1 = CtField.make("private int empno;",cc);
        CtField f2 = CtField.make("private String ename;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //��������
        CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}",cc);
        CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //��ӹ�����
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        constructor.setBody("{this.empno = empno; this.ename = ename;}");
        cc.addConstructor(constructor);

        cc.writeFile("D:\\idea-workspace\\out\\production\\idea-workspace");
        System.out.println("�����࣬�ɹ���");

    }
}
