package cn.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {
    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("�����ķ���ִ��ǰ��");
        System.out.println("��̸��ǩ��ͬ��Ԥ�������Ʊ");
        if ("sing".equals(method.getName())) {
            object = method.invoke(realStar, args);
        }
        System.out.println("�����ķ���ִ�к�");
        System.out.println("��β��");
        return object;
    }
}
