package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试Statement接口的用法，执行SQL语句，以及SQL注入问题
 * @author 黄建波
 */
public class Demo02 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","hjb19950925");
            statement = connection.createStatement();
/*            String sql = "insert into t_user (username,pwd,regTime) values ('赵六',6666,now())";
            statement.execute(sql);*/
            //测试SQL注入
            String id = "6";
            String sql = "delete from t_user where id="+id;
            statement.execute(sql);
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
