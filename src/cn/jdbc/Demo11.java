package cn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试使用JDBCUtil工具类来简化JDBC开发
 * @author 黄建波
 */
public class Demo11 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getMysqlConn();
            preparedStatement = connection.prepareStatement("insert into t_user (username) values (?);");
            preparedStatement.setString(1,"黄建波");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
    }
}
