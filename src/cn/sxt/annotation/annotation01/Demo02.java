package cn.sxt.annotation.annotation01;

@SxtAnnotation01
public class Demo02 {

    @SxtAnnotation01(age = 19, studentName = "�ϸ�", id = 1001,
    schools = {"������ѧ","�������캽�մ�ѧ"})
    public void test(){

    }

    @SxtAnnotation02("aaa")
    public void test2(){

    }
}
