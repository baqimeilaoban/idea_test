package cn.jdbc.testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用map来封装一条记录
 * 使用List<Map>,Map<Map>存储多条记录
 * @author 黄建波
 */
public class Demo02 {
    public static void test01(){
        Connection connection = JDBCUtil.getMysqlConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Map<String,Object> row = new HashMap<String, Object>();
        try {
            preparedStatement = connection.prepareStatement("select empname,salary,age from emp where id=?;");
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                row.put("empname",resultSet.getObject(1));
                row.put("salary",resultSet.getObject(2));
                row.put("age",resultSet.getObject(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }

        //遍历Map，就是遍历这一行多列的信息
        for (String key:row.keySet()){
            System.out.print(key + "---" + row.get(key) + "\t");
        }
    }

    public static void test02(){
        Connection connection = JDBCUtil.getMysqlConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map<String,Object>> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select empname,salary,age from emp where id>=?;");
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //使用一个Map封装一条记录
                Map<String,Object> row = new HashMap<>();
                row.put("empname",resultSet.getObject(1));
                row.put("salary",resultSet.getObject(2));
                row.put("age",resultSet.getObject(3));
                list.add(row);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        //遍历list
        for (Map<String,Object> row:list){
            for (String key:row.keySet()){
                System.out.print(key + "---" + row.get(key) + "\t");
            }
            System.out.println();
        }
    }

    public static void test03(){
        Connection connection = JDBCUtil.getMysqlConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Map<String,Map<String,Object>> maps = new HashMap<>();
        try {
            preparedStatement = connection.prepareStatement("select empname,salary,age from emp where id>=?;");
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //使用一个Map封装一条记录
                Map<String,Object> row = new HashMap<>();
                row.put("empname",resultSet.getObject(1));
                row.put("salary",resultSet.getObject(2));
                row.put("age",resultSet.getObject(3));
                maps.put(resultSet.getString(1),row);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        //遍历Map
        for (String empname:maps.keySet()){
            Map<String,Object> row = maps.get(empname);
            for (String key:row.keySet()){
                System.out.print(key + "---" + row.get(key) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test03();
    }
}
