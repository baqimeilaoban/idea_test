package cn.jdbc;

import java.sql.*;

/**
 * 测试批处理的基本用法
 * @author 黄建波
 */
public class Demo05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            //事务设为手动提交
            connection.setAutoCommit(false);
            long start = System.currentTimeMillis();
            statement = connection.createStatement();
            for (int i=0; i<20000; i++){
                statement.addBatch("insert into t_user (username,pwd,regTime) values ('黄"+i+"',666666,now())");
            }
            statement.executeBatch();
            //提交事务
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println("插入20000行数据，耗时" + (end-start) + "毫秒");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement!=null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

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
