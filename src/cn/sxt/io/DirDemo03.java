package cn.sxt.io;

/**
 * �ݹ飺�����Լ������Լ�
 * �ݹ�ͷ�����ʽ����Լ�
 * �ݹ��壺�ظ�����
 * @author �ƽ���
 */
public class DirDemo03 {
    public static void main(String[] args) {
        printTen(1);
    }

    public static void printTen(int n){
        //�ݹ�ͷ
        if (n > 10){
            return;
        }
        System.out.println(n);
        //�ݹ��壺�����Լ����Լ�
        printTen(n+1);
    }


}
