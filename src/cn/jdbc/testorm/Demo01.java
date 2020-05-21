package cn.jdbc.testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ʹ��Object[]����װһ����¼
 * ʹ��List<Object[]>�洢������¼
 * @author �ƽ���
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getMysqlConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object[]> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select empname,salary,age from emp where id>=?");
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Object[] objects = new Object[3];
                objects[0] = resultSet.getString(1);
                objects[1] = resultSet.getString(2);
                objects[2] = resultSet.getString(3);
                list.add(objects);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }

        for (Object[] object:list){
            System.out.println("" + object[0] + object[1] + object[2]);
        }
    }
}
