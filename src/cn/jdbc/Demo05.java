package cn.jdbc;

import java.sql.*;

/**
 * ����������Ļ����÷�
 * @author �ƽ���
 */
public class Demo05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //����������
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            //������Ϊ�ֶ��ύ
            connection.setAutoCommit(false);
            long start = System.currentTimeMillis();
            statement = connection.createStatement();
            for (int i=0; i<20000; i++){
                statement.addBatch("insert into t_user (username,pwd,regTime) values ('��"+i+"',666666,now())");
            }
            statement.executeBatch();
            //�ύ����
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println("����20000�����ݣ���ʱ" + (end-start) + "����");
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
