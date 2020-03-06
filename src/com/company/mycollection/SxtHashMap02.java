package com.company.mycollection;


/**
 * 自定义一个HashMap
 * 手写toString方法
 * @author 黄建波
 */
public class SxtHashMap02 {
    Node2[] table;
    int size;

    public SxtHashMap02(){
        table = new Node2[16];
    }

    public static int myHash(int v, int length){
        return v&(length - 1);
    }
    public void put(Object key,Object value){
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node2 temp = table[newNode.hash];
        Node2 iterLast = null;
        boolean keyRepeat = false;
        if (temp == null){
            table[newNode.hash] = newNode;
            size++;
        }else{
            while (temp != null){
                if (temp.key.equals(key)){
                    keyRepeat = true;
                    System.out.println("key重复了");
                    temp.value = value;
                    break;
                }else {
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if (!keyRepeat){
                iterLast.next = newNode;
                size++;
            }
        }
    }

    @Override
    public String toString() {
        //{10:aa,20:bb}
        StringBuilder sb = new StringBuilder("{");
        for (Node2 node2 : table) {
            Node2 temp = node2;
            while (temp != null) {
                sb.append(temp.key).append(":").append(temp.value).append(",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length() - 1,'}');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtHashMap02 m = new SxtHashMap02();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(20,"ss");
        m.put(53,"gg");
        m.put(69,"hh");
        m.put(85,"kk");
        System.out.println(m);
    }
}
