package cn.sxt.annotation.testcase;

/**
 * ���Լ򵥵ļ��ܽ��ܣ�ȡ��������
 * @author hjb
 */
public class Demo04 {
    public static void main(String[] args) throws Exception{
        //���ܺ��class�ļ�����������������޷����أ���classFormatError
        /*FileSystemClassLoder loder = new FileSystemClassLoder("D:\\idea-workspace\\out\\production\\idea-workspace\\cn\\sxt\\annotation\\testcase");
        Class<?> c = loder.loadClass("HelloWordEncrpt");
        System.out.println(c);*/

        DecrptClassLoder loder = new DecrptClassLoder("D:\\idea-workspace\\out\\production\\idea-workspace\\cn\\sxt\\annotation\\testcase");
        Class<?> c = loder.loadClass("HelloWordEncrpt");
        System.out.println(c);
    }
}
