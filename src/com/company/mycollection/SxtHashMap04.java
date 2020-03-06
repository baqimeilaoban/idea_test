package com.company.mycollection;

/**
 * 自定义HashMap
 * @author thinkpad
 */
public class SxtHashMap04<K,V> {
    Node3[] table;
    int size;

    public SxtHashMap04(){
        table = new Node3[16];
    }

    public static int myHash(int v, int length){
        return v&(length - 1);
    }

    public void put(K key, V value){
        Node3 newNode = new Node3();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node3 temp = table[newNode.hash];
        Node3 iterLast = null;
        boolean keyRepeat = false;
        if (temp == null){
            table[newNode.hash] = newNode;
            size++;
        }else {
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

    public V get(K key){
        int hash = myHash(key.hashCode(), table.length);
        V value = null;
        if (table[hash] != null){
            Node3 temp = table[hash];
            while (temp != null){
                if (temp.key.equals(key)){
                    value = (V) temp.value;
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
            Node3 temp = table[i];
            while (temp != null){
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtHashMap04<Integer,String> m = new SxtHashMap04<>();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(20,"ss");
        m.put(53,"gg");
        m.put(69,"hh");
        m.put(85,"kk");
        System.out.println(m);
        System.out.println(m.get(53));
        System.out.println(m.size);
    }
}
