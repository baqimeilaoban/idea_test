package cn.sxt.annotation.testcase;

/**
 * �����Զ����FileSystemClassLoder
 * @author thinkpad
 */
public class Demo03 {
    public static void main(String[] args) throws Exception{
        FileSystemClassLoder loder = new FileSystemClassLoder("D:\\idea-workspace\\out\\production\\idea-workspace");
        FileSystemClassLoder loder1 = new FileSystemClassLoder("D:\\idea-workspace\\out\\production\\idea-workspace");

        Class<?> c = loder.loadClass("cn.sxt.annotation.testcase.HelloWorld");
        Class<?> c1 = loder.loadClass("cn.sxt.annotation.testcase.HelloWorld");
        Class<?> c2 = loder1.loadClass("cn.sxt.annotation.testcase.HelloWorld");

        Class<?> c4 = loder1.loadClass("java.lang.String");
        Class<?> c5 = loder1.loadClass("cn.sxt.annotation.testcase.Demo01");
        System.out.println(c.hashCode());
        System.out.println(c1.hashCode());
        //ͬһ���࣬����ͬ�ļ��������أ�JVM��Ϊ�ǲ�ͬ����
        System.out.println(c2.hashCode());
        //�����������
        System.out.println(c4.getClassLoader());
        //�Զ����������
        System.out.println(c2.getClassLoader());
        //ϵͳĬ�ϵ��������
        System.out.println(c5.getClassLoader());

    }
}
