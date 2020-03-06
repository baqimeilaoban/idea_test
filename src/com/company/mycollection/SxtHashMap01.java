package com.company.mycollection;

/**
 *  自定义HashMap
 *  实现put方法增加键值对，并解决了键重复的时候覆盖相应的节点
 * @author 黄建波
 */
public class SxtHashMap01 {
    /**
     * 位桶数组
     */
    Node2[] table;
    /**
     * 存放的键值对的个数
     */
    int size;

    public SxtHashMap01() {
        //长度一般定义成2的整数幂
        table = new  Node2[16];
    }

    public void put(Object key, Object value){
        //定义新的节点对象
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(),table.length-1);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node2 temp = table[newNode.hash];
        //正在遍历的最后一个元素
        Node2 iterLast = null;
        boolean keyRepeat = false;
        if (temp == null){
            //此处数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
            size++;
        }else {
            //此处数组元素不为空，则遍历对应链表
            while (temp != null){
                //判断key如果重复，则覆盖
                if (temp.key.equals(key)) {
                    keyRepeat = true;
                    System.out.println("key重复了");
                    //只是覆盖value即可。其他组(hash,key,next)保持不变
                    temp.value = value;
                    break;
                }else {
                    //key不重复，则遍历下一个
                    iterLast =temp;
                    temp =temp.next;
                }
            }
            //如果没有发生key重复的情况，则添加到链表最后
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


