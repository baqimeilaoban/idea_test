package cn.sxt.location;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip.��λһ���ڵ㣺�������·�ɡ�ͨ���豸
 * InetAddress:�ṩ�����̬����
 * 1.getLocalHost:����
 * 2.getByName:��������DNS IP��ַ --->IP
 * ������Ա������
 * 1.getHostAddress:���ص�ַ
 * 2.getHostName:���ؼ������
 *
 * @author �ƽ���
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        //ʹ��getLocalHost��������InetAddress����
        InetAddress addr = InetAddress.getLocalHost();
        //����ip��ַ
        System.out.println(addr.getHostAddress());
        //����������
        System.out.println(addr.getHostName());
        System.out.println("----------------------------");
        //���������õ�InetAddress����
        addr = InetAddress.getByName("www.163.com");
        //����163��������ip
        System.out.println(addr.getHostAddress());
        //�����www.163.com
        System.out.println(addr.getHostName());
        System.out.println("----------------------------");

    }
}
