package cn.jdbc;

import java.io.*;
import java.sql.*;

/**
 * 测试BLOB 二进制大对象的使用
 * @author 黄建波
 */
public class Demo10 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            /*preparedStatement = connection.prepareStatement("insert into t_user (username,headimg) values (?,?);");
            preparedStatement.setString(1,"黄");
            preparedStatement.setBlob(2,new FileInputStream("C:\\Users\\黄建波\\Desktop\\idea_test\\src\\cn\\jdbc\\iPhone.png"));
            preparedStatement.execute();*/

            preparedStatement = connection.prepareStatement("select * from t_user where id=?");
            preparedStatement.setObject(1,21029);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Blob blob = resultSet.getBlob("headimg");
                inputStream = blob.getBinaryStream();
                outputStream = new FileOutputStream("C:\\Users\\黄建波\\Desktop\\idea_test\\src\\cn\\jdbc\\iPhone1.png");
                int temp = 0;
                while ((temp=inputStream.read())!=-1){
                    outputStream.write(temp);
                }
            }
        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (outputStream!=null){
                    outputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if (inputStream!=null){
                    inputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

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
