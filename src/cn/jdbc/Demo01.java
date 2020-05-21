package cn.jdbc;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试跟数据库建立链接
 * @author 黄建波
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            //建立连接，比较耗时
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            long end  = System.currentTimeMillis();
            System.out.println(connection);
            System.out.println("建立连接，耗时：" + (end-start) + "毫秒");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
