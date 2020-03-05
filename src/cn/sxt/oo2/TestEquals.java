package cn.sxt.oo2;

import java.util.Objects;

/**
 * ����==��Equals
 * @author �ƽ���
 */
public class TestEquals {
    public static void main(String[] args) {
        Object obj;
        String str;

        User u1 = new User(1000,"�ƽ���","123456");
        User u2 = new User(1000,"������","123456");

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
     * ������
     * @param id��ѧ��
     * @param name������
     * @param pwd������
     */
    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    //��дequals����


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        //���o�ǿա��򷵻�false
        if (!(o instanceof User)) {
            return false;
        }
        //ǿ��ת��
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}