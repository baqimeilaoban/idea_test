package cn.designpattern.prototype;

/**
 * ������ͨnew��ʽ���������clone��ʽ���������Ч�ʲ���
 * �����Ҫ��ʱ�䴴���������󣬲���new�ȽϺ�ʱ������Կ���ʹ��ԭ��ģʽ
  @author thinkpad
 */
public class Client4 {
    public static void testNew(int size){
        long start = System.currentTimeMillis();
        for (int i=0;i<size;i++){
            Laptop t = new Laptop();
        }
        long end = System.currentTimeMillis();
        System.out.println("new��ʽ������ʱ��" + (end-start));
    }

    public static void testClone(int size) throws CloneNotSupportedException {
        long start = System.currentTimeMillis();
        Laptop t = new Laptop();
        for (int i=0;i<size;i++){
            Laptop temp = (Laptop)t.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("clone�ķ�ʽ������ʱ��" + (end-start));
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        testNew(1000);
        testClone(1000);
    }
}

/**
 * �ʼǱ�����
 */
class Laptop implements Cloneable{
    public Laptop(){
        try {
            //ģ�ⴴ�������ʱ�Ĺ���
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //ֱ�ӵ���object�����clone()����
        Object obj = super.clone();
        return obj;
    }
}
