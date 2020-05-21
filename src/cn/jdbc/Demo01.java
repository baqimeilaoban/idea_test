package cn.jdbc;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���Ը����ݿ⽨������
 * @author �ƽ���
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            //����������
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            //�������ӣ��ȽϺ�ʱ
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            long end  = System.currentTimeMillis();
            System.out.println(connection);
            System.out.println("�������ӣ���ʱ��" + (end-start) + "����");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
