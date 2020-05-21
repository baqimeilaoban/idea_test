package cn.jdbc;

import java.io.*;
import java.sql.*;

/**
 * ����CLOB �ı�������ʹ��
 * ���������ַ������ļ����ݲ������ݿ��е�CLOB�ֶΡ���CLOB�ֶ�ֵȡ�����Ĳ���
 * @author �ƽ���
 */
public class Demo09 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Reader reader = null;
        try {
            //����������
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            /*preparedStatement = connection.prepareStatement("insert into t_user (username,myinfo) values (?,?);");
            preparedStatement.setString(1,"��");
            //���ı��ļ�����ֱ�����뵽���ݿ���
            preparedStatement.setClob(2,new FileReader(new File("C:\\Users\\�ƽ���\\Desktop\\idea_test\\src\\cn\\jdbc\\a.txt")));
            //�������е��ַ������뵽���ݿ��CLOB�ֶ���
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
