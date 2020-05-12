package cn.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ԫ������
 * @author hjb
 */
public class ChessFlyWeightFactory {
    /**
     * ��Ԫ��
     */
    private static Map<String,ChessFlyWeight> map = new HashMap<>();
    public static ChessFlyWeight getChess(String color){
        if (map.get(color)!=null){
            return map.get(color);
        }else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color,cfw);
            return cfw;
        }
    }
}
