package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ����PreparedStatement
 * @author �ƽ���
 */
public class Demo03 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            //?ռλ��
            String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";
            ps = connection.prepareStatement(sql);
            assert ps != null;
            ps.setString(1,"�ƽ���1");
            ps.setString(2,"2ss");
            ps.setString(3, String.valueOf(new java.sql.Date(System.currentTimeMillis())));
            System.out.println("����һ�м�¼");
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps!=null){
                    ps.close();
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
