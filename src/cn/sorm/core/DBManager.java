package cn.sorm.core;

import cn.sorm.bean.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @author 黄建波
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
            //直接建立连接，后期增加连接池处理，提高效率
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
     * 返回Configuration对象
     * @return
     */
    public static Configuration getConf(){
        return configuration;
    }
}
