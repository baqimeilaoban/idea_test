package com.company.mycollection;

/**
 *  �Զ���HashMap
 *  ʵ��put�������Ӽ�ֵ�ԣ�������˼��ظ���ʱ�򸲸���Ӧ�Ľڵ�
 * @author �ƽ���
 */
public class SxtHashMap01 {
    /**
     * λͰ����
     */
    Node2[] table;
    /**
     * ��ŵļ�ֵ�Եĸ���
     */
    int size;

    public SxtHashMap01() {
        //����һ�㶨���2��������
        table = new  Node2[16];
    }

    public void put(Object key, Object value){
        //�����µĽڵ����
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(),table.length-1);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node2 temp = table[newNode.hash];
        //���ڱ��������һ��Ԫ��
        Node2 iterLast = null;
        boolean keyRepeat = false;
        if (temp == null){
            //�˴�����Ԫ��Ϊ�գ���ֱ�ӽ��½ڵ�Ž�ȥ
            table[newNode.hash] = newNode;
            size++;
        }else {
            //�˴�����Ԫ�ز�Ϊ�գ��������Ӧ����
            while (temp != null){
                //�ж�key����ظ����򸲸�
                if (temp.key.equals(key)) {
                    keyRepeat = true;
                    System.out.println("key�ظ���");
                    //ֻ�Ǹ���value���ɡ�������(hash,key,next)���ֲ���
                    temp.value = value;
                    break;
                }else {
                    //key���ظ����������һ��
                    iterLast =temp;
                    temp =temp.next;
                }
            }
            //���û�з���key�ظ������������ӵ��������
            if (!keyRepeat){
                iterLast.next = newNode;
                size++;
            }
        }

    }

    public static int myHash(int v, int length){
        //System.out.println("hash in myHash:" + (v&(length-1)));
        return v&(length - 1);
    }

    public static void main(String[] args) {
        SxtHashMap01 m = new SxtHashMap01();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(20,"ss");
        m.put(53,"gg");
        m.put(69,"hh");
        m.put(85,"kk");
        System.out.println(m);

        for (int i = 10; i < 100; i++){
            /**
             * 53,69,85
             */
            System.out.println(i + "-----" + myHash(i,16));
        }
    }
}


