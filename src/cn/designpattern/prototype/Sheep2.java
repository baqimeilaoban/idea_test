package cn.designpattern.prototype;

import java.util.Date;

public class Sheep2 implements Cloneable{
    private String sname;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        //������´���ʵ�����
        Sheep2 s = (Sheep2)obj;
        //������Ҳ���п�¡
        s.birthday = (Date)this.birthday.clone();
        return obj;
    }

    public Sheep2(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    public Sheep2() {
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
