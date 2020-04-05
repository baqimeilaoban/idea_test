package cn.sxt.exception;

/**
 * 运行时异常的处理
 * RuntimeException
 * @author 黄建波
 */
public class Test01 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        if (a!=0){
            System.out.println(b/a);
        }
        String str = null;
        //解决办法
        if (str!=null){
            //会出现空指针异常 java.lang.NullPointerException
            str.length();
        }

        Animal animal = new Dog();
        //解决办法
        if (animal instanceof Cat){
            //会出现java.lang.ClassCastException
            Cat cat = (Cat)animal;
        }

        int[] arr = new int[5];
        int arr1 = 5;
        //解决办法
        if (arr1<arr.length){
            //出现越界异常java.lang.ArrayIndexOutOfBoundsException
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
