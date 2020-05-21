package cn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ����ʹ��JDBCUtil����������JDBC����
 * @author �ƽ���
 */
public class Demo11 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getMysqlConn();
            preparedStatement = connection.prepareStatement("insert into t_user (username) values (?);");
            preparedStatement.setString(1,"�ƽ���");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
    }
}
