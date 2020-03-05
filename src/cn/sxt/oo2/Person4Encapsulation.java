package cn.sxt.oo2;

/**
 * ÈÔÈ»²âÊÔ·â×°
 * @author »Æ½¨²¨
 */
public class Person4Encapsulation {
    private int id;
    private String name;
    private int age;
    private boolean man;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        if (age >= 18 && age <= 130) {
            this.age = age;
        }else {
            System.out.println("ÇëÊäÈëÕı³£µÄÄêÁä£¡");
        }
    }

    public int getAge(){
        return this.age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }
}
