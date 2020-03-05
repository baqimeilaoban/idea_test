package cn.sxt.oo2;

import java.util.Objects;

/**
 * 测试==和Equals
 * @author 黄建波
 */
public class TestEquals {
    public static void main(String[] args) {
        Object obj;
        String str;

        User u1 = new User(1000,"黄建波","123456");
        User u2 = new User(1000,"黄梦瑶","123456");

        System.out.println(u1 == u2);
        System.out.println(u1.equals(u2));

        String str1 = new String("sxt");
        String str2 = new String("sxt");
        //false
        System.out.println(str1 == str2);
        //true
        System.out.println(str1.equals(str2));
    }
}

class User{
    int id;
    String name;
    String pwd;

    /**
     * 构造器
     * @param id：学号
     * @param name：姓名
     * @param pwd：密码
     */
    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    //重写equals方法


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        //如果o是空。则返回false
        if (!(o instanceof User)) {
            return false;
        }
        //强制转型
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}