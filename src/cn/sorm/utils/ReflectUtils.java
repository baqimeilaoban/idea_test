package cn.sorm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ��װ�˷���ĳ��ò���
 * @author �ƽ���
 */
public class ReflectUtils {
    /**
     * ����obj�����Ӧ������fieldName��get����
     * @param fieldName
     * @param obj
     * @return
     */
    public static Object invokeGet(String fieldName,Object obj){
        try {
            Class c = obj.getClass();
            Method m = c.getDeclaredMethod("get" + StringUtils.firstChar2UpperCase(fieldName),null);
            return m.invoke(obj,null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void invokeSet(Object obj, String columnName,Object columnValue){
        try {
            Method m = obj.getClass().getDeclaredMethod("set" + StringUtils.firstChar2UpperCase(columnName),columnValue.getClass());
            m.invoke(obj,columnValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
