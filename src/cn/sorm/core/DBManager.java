package cn.sorm.core;

import cn.sorm.bean.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * ����������Ϣ��ά�����Ӷ���Ĺ����������ӳع��ܣ�
 * @author �ƽ���
 */
public class DBManager {
    private static Configuration configuration;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn\\sorm\\db.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        configuration = new Configuration();
        configuration.setDriver(properties.getProperty("driver"));
        configuration.setPoPackage(properties.getProperty("poPackage"));
        configuration.setPwd(properties.getProperty("pwd"));
        configuration.setSrcPath(properties.getProperty("srcPath"));
        configuration.setUrl(properties.getProperty("url"));
        configuration.setUser(properties.getProperty("user"));
        configuration.setUsingDB(properties.getProperty("usingDB"));
    }

    public static Connection getConn(){
        try {
            Class.forName(configuration.getDriver());
            //ֱ�ӽ������ӣ������������ӳش������Ч��
            return DriverManager.getConnection(configuration.getUrl(),configuration.getUser(),configuration.getPwd());
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
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

    /**
     * ����Configuration����
     * @return
     */
    public static Configuration getConf(){
        return configuration;
    }
}
