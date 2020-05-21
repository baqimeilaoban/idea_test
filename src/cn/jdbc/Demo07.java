package cn.jdbc;

import java.sql.*;
import java.util.Random;

/**
 * 测试时间处理（java.sql.Date,Time,Timestamp）
 * @author 黄建波
 */
public class Demo07 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            for (int i=0; i<1000; i++){
                preparedStatement = connection.prepareStatement("insert into t_user (username,pwd,regTime,lastLoginTime) values (?,?,?,?);");
                preparedStatement.setObject(1,"黄"+i);
                preparedStatement.setObject(2,"123456");
                int rand = 100000000 + new Random().nextInt(1000000000);
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-rand);
                //如果需要插入指定日期，可以使用Calendar,DateFormat
                Timestamp timestamp = new Timestamp(System.currentTimeMillis()-rand);
                preparedStatement.setDate(3,date);
                preparedStatement.setTimestamp(4,timestamp);
                preparedStatement.execute();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
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
