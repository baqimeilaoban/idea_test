package cn.designpattern.adapter;

/**
 * ������ (������������ʽ,ʹ������ϵķ�ʽ���������������)
 * (�൱��usb��ps/2��ת����)
 * @author hjb
 */
public class Adapter2 implements Target{
    private Adaptee adaptee;
    @Override
    public void handleReq() {
        adaptee.request();
    }

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
