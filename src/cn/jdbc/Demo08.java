package cn.jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试时间处理（java.sql.Date,Time,Timestamp)，取出指定时间段的数据
 * @author 黄建波
 */
public class Demo08 {
    /**
     * 将字符串代表的日期转为long数字（格式：yyyy-MM-dd hh:mm:ss）
     * @param dateStr
     * @return
     */
    public static long str2Date(String dateStr){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =  null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
/*
            preparedStatement = connection.prepareStatement("select * from t_user where regTime>? and regTime<? order by regTime");
            java.sql.Date start = new java.sql.Date(str2Date("2020-05-10 17:22:11"));
            java.sql.Date end = new java.sql.Date(str2Date("2020-05-15 16:39:44"));
            preparedStatement.setObject(1,start);
            preparedStatement.setObject(2,end);
*/
            preparedStatement = connection.prepareStatement("select * from t_user where lastLoginTime>? and lastLoginTime<? order by lastLoginTime");
            Timestamp start = new Timestamp(str2Date("2020-05-10 17:22:11"));
            Timestamp end = new Timestamp(str2Date("2020-05-15 16:39:44"));
            preparedStatement.setObject(1,start);
            preparedStatement.setObject(2,end);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + "---" + resultSet.getString("username") + "---" + resultSet.getTimestamp(

                        "lastLoginTime"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet!=null){
                    resultSet.close();
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
