package cn.jdbc;

import java.io.*;
import java.sql.*;

/**
 * 测试CLOB 文本大对象的使用
 * 包含：将字符串、文件内容插入数据库中的CLOB字段、将CLOB字段值取出来的操作
 * @author 黄建波
 */
public class Demo09 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Reader reader = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            /*preparedStatement = connection.prepareStatement("insert into t_user (username,myinfo) values (?,?);");
            preparedStatement.setString(1,"黄");
            //将文本文件内容直接输入到数据库中
            preparedStatement.setClob(2,new FileReader(new File("C:\\Users\\黄建波\\Desktop\\idea_test\\src\\cn\\jdbc\\a.txt")));
            //将程序中的字符串输入到数据库的CLOB字段中
            preparedStatement.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaabbbbbbb".getBytes()))));
            preparedStatement.executeUpdate();*/

            preparedStatement = connection.prepareStatement("select * from t_user where id=?");
            preparedStatement.setObject(1,21027);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Clob clob = resultSet.getClob("myinfo");
                reader = clob.getCharacterStream();
                int temp = 0;
                while ((temp=reader.read())!=-1){
                    System.out.print((char)temp);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader!=null){
                    reader.close();
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
