package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试事务的基本概念和用法
 * @author 黄建波
 */
public class Demo06 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            //            //JDBC中默认是true，自动提交事务
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into t_user (username,pwd) values (?,?);");
            preparedStatement.setObject(1,"搞起");
            preparedStatement.setObject(2,"123456");
            preparedStatement.execute();
            System.out.println("插入一个用户：搞起");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            preparedStatement1 = connection.prepareStatement("insert into t_user (username,pwd) values (?,?);");
            preparedStatement1.setObject(1,"马士兵");
            preparedStatement1.setObject(2,"123456");
            preparedStatement1.execute();
            System.out.println("插入一个用户，马士兵");
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                //回滚
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement1!=null){
                    preparedStatement1.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if (preparedStatement!=null){
                    preparedStatement.close();
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
