package cn.sxt.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * �������ͣ����ն� ��������
 * 1.ʹ��DatagramSocketָ���˿� �������ն�
 * 2.׼������ ��װ��DatagramPacket����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.�������� ���ֽ����黹ԭΪ��Ӧ������
 *  getData()
 *  getLength()
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpObjServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("���ն������С�����");
        //ʹ��DatagramSocketָ���˿� �������ն�
        DatagramSocket server = new DatagramSocket(6666);
        //׼������ ��װ��DatagramPacket����
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //����ʽ���հ���
        server.receive(packet);
        //��������
        byte[] datas = packet.getData();
        int len = packet.getLength();
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(flag);
        Object str = dis.readObject();
        Object date = dis.readObject();
        Object employee = dis.readObject();
        if (str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if (date instanceof Date){
            Date dateObj = (Date)date;
            System.out.println(dateObj);
        }
        if (employee instanceof Employee){
            Employee empObj = (Employee) employee;
            System.out.println(empObj.getName() + "--->" + empObj.getSalary());
        }
        //�ͷ���Դ
        server.close();
    }
}
