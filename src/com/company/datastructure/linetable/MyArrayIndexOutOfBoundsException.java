package com.company.datastructure.linetable;

/**
 * 自定义异常
 * @author 黄建波
 */
public class MyArrayIndexOutOfBoundsException  extends RuntimeException{
    public MyArrayIndexOutOfBoundsException() {
    }

    public MyArrayIndexOutOfBoundsException(String message) {
        super(message);
    }
}
