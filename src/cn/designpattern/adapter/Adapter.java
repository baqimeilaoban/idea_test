package cn.designpattern.adapter;

/**
 * ������������������ʽ��
 * ���൱��usb��ps/2��ת������
 * @author thinkpad
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void handleReq() {
        super.request();
    }
}
