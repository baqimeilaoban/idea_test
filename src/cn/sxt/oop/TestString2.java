package cn.sxt.oop;

/**
 * �����ַ����ĳ��÷���
 * @author �ƽ���
 */
public class TestString2 {
    public static void main(String[] args) {
        String s1 = "core java";
        String s2 = "Core java";
        //��ȡ�±�Ϊ3���ַ�
        System.out.println(s1.charAt(3));
        //�ַ����ĳ���
        System.out.println(s2.length());
        //�Ƚ������ַ����Ƿ����
        System.out.println(s1.equals(s2));
        //�Ƚ������ַ��������Դ�Сд��
        System.out.println(s1.equalsIgnoreCase(s2));
        //�ַ���s1���Ƿ����java
        System.out.println(s1.indexOf("java"));
        //�ַ���s1���Ƿ����apple
        System.out.println(s1.indexOf("apple"));
        //��s1�еĿո��滻��&
        String s = s1.replace(' ', '&');
        System.out.println("result is:" + s);

        String s3 = "";
        String s4 = "How are you?";
        //�Ƿ���How��ͷ
        System.out.println(s4.startsWith("How"));
        //�Ƿ���you��β
        System.out.println(s4.endsWith("you"));
        //��ȡ���ַ��������±�Ϊ4�Ŀ�ʼ���ַ�����βΪֹ
        s3 = s4.substring(4);
        System.out.println(s3);
        //��ȡ���ַ������±�[4,7]������7
        s3 = s4.substring(4,7);
        System.out.println(s3);
        //תСд
        s3 = s4.toLowerCase();
        System.out.println(s3);
        //ת��д
        s3 = s4.toUpperCase();
        System.out.println(s3);
        String s5 = "How old are you!!";
        //ȥ���ַ�����β�Ŀո�ע�⣺�м�Ŀո���ȥ��
        s3 = s5.trim();
        System.out.println(s3);
        //��ΪString�ǲ��ɱ��ַ���������s5����
        System.out.println(s5);
    }
}
