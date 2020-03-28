package cn.sxt.io3;

/**
 * 实现放大器对声音放大的功能
 * @author 黄建波
 */
public class DecorateTest01 {
    public static void main(String[] args) {
        Person p = new Person();
        p.say();

        //装饰
        Amplifier am = new Amplifier(p);
        am.say();
    }
}

interface Say{
    void say();
}

class Person implements Say{
    /**
     * 添加属性
     */
    private int voice = 10;
    @Override
    public void say() {
        System.out.println("人的声音为：" + this.getVoice());
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say{
    /**
     * 对人声音的装饰放大
     */
    private Person p;

    public Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为：" + p.getVoice()*100);
        System.out.println("噪音。。。。");
    }
}
