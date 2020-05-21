package cn.jdbc;

import java.sql.*;
import java.util.Random;

/**
 * ����ʱ�䴦��java.sql.Date,Time,Timestamp��
 * @author �ƽ���
 */
public class Demo07 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //����������
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            for (int i=0; i<1000; i++){
                preparedStatement = connection.prepareStatement("insert into t_user (username,pwd,regTime,lastLoginTime) values (?,?,?,?);");
                preparedStatement.setObject(1,"��"+i);
                preparedStatement.setObject(2,"123456");
                int rand = 100000000 + new Random().nextInt(1000000000);
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-rand);
                //�����Ҫ����ָ�����ڣ�����ʹ��Calendar,DateFormat
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
