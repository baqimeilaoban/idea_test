package cn.designpattern.memento;

/**
 * Դ������
 * @author �ƽ���
 */
public class Emp {
    private String ename;
    private int age;
    private double salary;

    /**
     * ���б���¼����
     */
    public EmpMemento memento(){
        return new EmpMemento(this);
    }

    /**
     * �������ݻָ����ָ����ƶ�����¼�����ֵ
     */
    public void recovery(EmpMemento mmt){
        this.ename = mmt.getEname();
        this.age = mmt.getAge();
        this.salary = mmt.getSalary();
    }

    public Emp(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
