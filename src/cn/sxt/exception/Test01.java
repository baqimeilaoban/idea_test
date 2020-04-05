package cn.sxt.exception;

/**
 * ����ʱ�쳣�Ĵ���
 * RuntimeException
 * @author �ƽ���
 */
public class Test01 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        if (a!=0){
            System.out.println(b/a);
        }
        String str = null;
        //����취
        if (str!=null){
            //����ֿ�ָ���쳣 java.lang.NullPointerException
            str.length();
        }

        Animal animal = new Dog();
        //����취
        if (animal instanceof Cat){
            //�����java.lang.ClassCastException
            Cat cat = (Cat)animal;
        }

        int[] arr = new int[5];
        int arr1 = 5;
        //����취
        if (arr1<arr.length){
            //����Խ���쳣java.lang.ArrayIndexOutOfBoundsException
            System.out.println(arr[arr1]);
        }

    }
}

class Animal{

}

class Dog extends Animal{

}

class Cat extends Animal{

}
