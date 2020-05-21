package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��������Ļ���������÷�
 * @author �ƽ���
 */
public class Demo06 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            //����������
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            //            //JDBC��Ĭ����true���Զ��ύ����
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into t_user (username,pwd) values (?,?);");
            preparedStatement.setObject(1,"����");
            preparedStatement.setObject(2,"123456");
            preparedStatement.execute();
            System.out.println("����һ���û�������");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            preparedStatement1 = connection.prepareStatement("insert into t_user (username,pwd) values (?,?);");
            preparedStatement1.setObject(1,"��ʿ��");
            preparedStatement1.setObject(2,"123456");
            preparedStatement1.execute();
            System.out.println("����һ���û�����ʿ��");
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                //�ع�
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
