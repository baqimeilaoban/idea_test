package com.company.mycollection;


/**
 * 自定义HashMap
 * 添加get方法
 * @author 黄建波
 */
public class SxtHashMap03 {
    Node2[] table;
    int size;

    public SxtHashMap03(){
        table = new Node2[16];
    }

    public static int myHash(int v, int length){
        return v&(length -1);
    }

    public void put(Object key, Object value){

        //如果要完善，还需要考虑数组的扩容问题


        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node2 temp = table[newNode.hash];
        Node2 iterLast = null;
        boolean keyRepeat = false;
        if (temp == null){
            table[newNode.hash] = newNode;
            size++;
        }else {
            while (temp != null){
                if (temp.key.equals(key)){
                    keyRepeat = true;
                    System.out.println("key重复了！");
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

    public Object get(Object key){
        int hash = myHash(key.hashCode(), table.length);
        Object value = null;
        if (table[hash] != null){
            Node2 temp = table[hash];
            while (temp != null){
                if (temp.key.equals(key)){
                    //如果相等，说明找到了键值对，返回响应的value
                    value = temp.value;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }
        return value;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < table.length; i++){
            Node2 temp = table[i];
            while (temp != null){
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtHashMap03 m = new SxtHashMap03();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(20,"ss");
        m.put(53,"gg");
        m.put(69,"hh");
        m.put(85,"kk");
        System.out.println(m);
        System.out.println(m.get(53));
    }
}
