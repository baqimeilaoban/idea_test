package cn.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装JDBC查询常用操作
 * @author 黄建波
 */
public class JDBCUtils {
    public static void handleParams(PreparedStatement preparedStatement,Object[] params){
        if (params!=null){
            for (int i=0; i<params.length; i++){
                try {
                    preparedStatement.setObject(1+i,params[i]);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
