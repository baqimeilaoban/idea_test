package cn.sxt.annotation.testcase;

/**
 * 测试简单的加密解密（取反）操作
 * @author hjb
 */
public class Demo04 {
    public static void main(String[] args) throws Exception{
        //加密后的class文件，正常的类加载器无法加载，报classFormatError
        /*FileSystemClassLoder loder = new FileSystemClassLoder("D:\\idea-workspace\\out\\production\\idea-workspace\\cn\\sxt\\annotation\\testcase");
        Class<?> c = loder.loadClass("HelloWordEncrpt");
        System.out.println(c);*/

        DecrptClassLoder loder = new DecrptClassLoder("D:\\idea-workspace\\out\\production\\idea-workspace\\cn\\sxt\\annotation\\testcase");
        Class<?> c = loder.loadClass("HelloWordEncrpt");
        System.out.println(c);
    }
}
