package cn.sxt.io;

import java.io.File;

/**
 * ���ƻ�·��
 * getName():��ȡ����
 * getPath()����ԡ�����
 * getAbsolutePath()������
 * getParent():����·��û�У��򷵻�null
 * @author �ƽ���
 */
public class TestFileDemo03 {
    public static void main(String[] args) {
        File src = new File("D:\\idea-workspace\\src\\cn\\sxt\\io\\IO.png");
        //������Ϣ
        System.out.println("����" + src.getName());
        System.out.println("·����" + src.getPath());
        System.out.println("����·����" + src.getAbsolutePath());
        System.out.println("��·����" + src.getParent());
        System.out.println("������" + src.getParentFile().getName());
    }
}
