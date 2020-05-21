package cn.jdbc;

import java.sql.*;

/**
 * ����ResultSet������Ļ����÷�
 * @author �ƽ���
 */
public class Demo04 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            //?ռλ��
            String sql = "select id,username,pwd from t_user where id>?";
            preparedStatement = connection.prepareStatement(sql);
            //��id����7�ļ�¼��ȡ����
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
            //��ѭ��resultSet - preparedStatement - connection�����Ĺر�˳��һ��Ҫ������trycatch��ֿ�д
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
