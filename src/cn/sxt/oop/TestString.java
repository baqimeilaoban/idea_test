package cn.sxt.oop;

/**
 * ����String�ַ���
 * @author �ƽ���
 */
public class TestString {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("def");
        String str3 = "abc" + "defgh";
        //��ʱ���Ǽӷ��������ӷ�
        String str4 = "18" + 19;
        System.out.println(str4);

        System.out.println("**************************");
        String str10 = "gaoqi";
        String str11 = "gaoqi";
        String str12 = new String("gaoqi");

        //==�Ƚϵ��Ƕ���
        System.out.println(str10 == str11);
        System.out.println(str10.equals(str11));
        //str11��str12����ͬһ������
        System.out.println(str11 == str12);

        //ͨ���Ƚ��ַ���ʹ�õ���equals��equals�Ƚϵ�������
        System.out.println(str11.equals(str12));
    }
}
