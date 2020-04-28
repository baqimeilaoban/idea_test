package cn.sxt.annotation.annotation01;

@SxtAnnotation01
public class Demo02 {

    @SxtAnnotation01(age = 19, studentName = "老高", id = 1001,
    schools = {"北京大学","北京航天航空大学"})
    public void test(){

    }

    @SxtAnnotation02("aaa")
    public void test2(){

    }
}
