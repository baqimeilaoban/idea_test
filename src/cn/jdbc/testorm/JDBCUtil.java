package cn.jdbc.testorm;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC������
 * @author �ƽ���
 */
public class JDBCUtil {
    /**
     * ���԰�����ȡ�ʹ�����Դ�ļ��е���Ϣ
     */
    static Properties properties = null;

    /**
     * ����JDBCUtil���ʱ�����
     */
    static {
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/jdbc/testorm/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConn(){
        try {
            Class.forName(properties.getProperty("mysqlDriver"));
            return DriverManager.getConnection(properties.getProperty("mysqlURL"),properties.getProperty("mysqlUser"),properties.getProperty("mysqlPwd"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getOracleConn(){
        try {
            Class.forName(properties.getProperty("oracleDriver"));
            return DriverManager.getConnection(properties.getProperty("oracleURL"),properties.getProperty("oracleUser"),properties.getProperty("oraclePwd"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

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

    public static void close(Statement statement,Connection connection){
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

    public static void close(Connection connection){
        try {
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
