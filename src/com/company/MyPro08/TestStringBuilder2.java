package com.company.MyPro08;

/**
 * ����StringBuilder��StringBuffer�ɱ��ַ����еĳ��÷���
 * @author �ƽ���
 */
public class TestStringBuilder2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            char temp = (char)('a' + i);
            sb.append(temp);
        }
        System.out.println(sb);

        //����reverse
        sb.reverse();
        System.out.println(sb);
        //����setCharAt
        sb.setCharAt(3,'��');
        System.out.println(sb);
        //����insert
        sb.insert(0,'��');
        System.out.println(sb);
        //����insert��ʽ���ã����ľ��Ǹ÷���������return this�����Լ�������
        sb.insert(0,'��').insert(6,'��').insert(10," ");
        System.out.println(sb);
        //����delete��Ҳ��ʹ����ʽ����
        sb.delete(20,23);
        System.out.println(sb);
    }
}
