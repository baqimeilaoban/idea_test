package cn.jdbc;

import java.sql.*;

/**
 * 测试ResultSet结果集的基本用法
 * @author 黄建波
 */
public class Demo04 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            //?占位符
            String sql = "select id,username,pwd from t_user where id>?";
            preparedStatement = connection.prepareStatement(sql);
            //把id大于7的记录都取出来
            preparedStatement.setObject(1,7);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "---" + resultSet.getString(2) + "---" + resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            //遵循：resultSet - preparedStatement - connection这样的关闭顺序！一定要将三个trycatch块分开写
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
