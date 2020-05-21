package cn.jdbc.testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用Javabean对象来封装一条记录
 * 使用List<Javabean>存储多条记录
 *
 * @author 黄建波
 */
public class Demo03 {
    public static void test01(){
        Connection connection = JDBCUtil.getMysqlConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            preparedStatement = connection.prepareStatement("select empname,salary,age from emp where id=?;");
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                emp = new Emp(resultSet.getString(1),resultSet.getInt(3),resultSet.getDouble(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }

        System.out.println(emp.getEmpname() + "--" +emp.getAge() + "--" + emp.getSalary());
    }

    public static void test02(){
        Connection connection = JDBCUtil.getMysqlConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Emp> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select empname,salary,age from emp where id>=?;");
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Emp emp = new Emp(resultSet.getString(1),resultSet.getInt(3),resultSet.getDouble(2));
                list.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }

        //遍历List
        for (Emp emp:list){
            System.out.println(emp.getEmpname() + "-" + emp.getAge() + "-" + emp.getSalary());
        }
    }
    public static void main(String[] args) {
        test02();
    }
}
