package cn.sorm.core;

import cn.jdbc.testorm.JDBCUtil;
import cn.sorm.bean.ColumnInfo;
import cn.sorm.bean.TableInfo;
import cn.sorm.po.Emp;
import cn.sorm.utils.JDBCUtils;
import cn.sorm.utils.ReflectUtils;
import cn.sorm.vo.EmpVO;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责真的Mysql数据库的查询
 * @author 黄建波
 */
public class MysqlQuery implements Query{
    public static void testDML(){
        Emp e = new Emp();
        e.setId(1);
        e.setEmpname("lily");
        e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
        e.setAge(30);
        e.setSalary(3000.0);
        //new MysqlQuery().delete(e);
        new MysqlQuery().update(e,new String[]{"empname","age","salary"});
    }

    public static void testQueryRows(){
        List<Emp> list = new MysqlQuery().queryRows("select id,empname,age from emp where age>? and salary<?",
                Emp.class, new Object[]{10,5000});

        for(Emp e:list){
            System.out.println(e.getEmpname());
        }

        String sql2 = "select e.id,e.empname,salary+bonus 'xinshui',age,d.dname 'deptName',d.address 'deptAddr' from emp e "
                +"join dept d on e.deptId=d.id ";
        List<EmpVO> list2 = new MysqlQuery().queryRows(sql2,
                EmpVO.class, null);

        for(EmpVO e:list2){
            System.out.println(e.getEmpname()+"-"+e.getAddress()+"-"+e.getXinshui());
        }

    }
    public static void main(String[] args) {
       testQueryRows();
    }

    @Override
    public int executeDML(String sql, Object[] params) {
        Connection connection = DBManager.getConn();
        int count = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //给sql设参
            JDBCUtils.handleParams(preparedStatement,params);
            System.out.println(preparedStatement);
            count = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBManager.close(preparedStatement,connection);
        }
        return count;
    }

    @Override
    public void insert(Object obj) {
        //obj-->表中 insert into 表名 (id,uname,pwd) values (?,?,?)
        Class c = obj.getClass();
        //存储sql的参数对象
        List<Object> params = new ArrayList<>();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTname() + " (");
        //计算部位null的属性值
        int countNotNullField = 0;
        Field[] fs = c.getDeclaredFields();
        for (Field f:fs){
            String fieldName = f.getName();
            Object fieldValue = ReflectUtils.invokeGet(fieldName,obj);
            if (fieldValue!=null){
                countNotNullField++;
                sql.append(fieldName + ",");
                params.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length()-1,')');
        sql.append(" values (");
        for (int i=0; i<countNotNullField; i++){
            sql.append("?,");
        }
        sql.setCharAt(sql.length()-1,')');
        executeDML(sql.toString(),params.toArray());
    }

    @Override
    public void delete(Class clazz, Object id) {
        //Emp.class,2-->delete from emp where id=2
        //通过class对象找TableInfo
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
        //获得主键
        ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();
        String sql = "delete from " + tableInfo.getTname() + " where " + onlyPrikey.getName() + "=?";
        executeDML(sql,new Object[]{id});
    }

    @Override
    public void delete(Object obj) {
        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        //主键
        ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();
        //通过反射机制，调用属性对应的get方法和set方法
        Object prikeyValue = ReflectUtils.invokeGet(onlyPrikey.getName(),obj);
        delete(c,prikeyValue);
    }

    @Override
    public int update(Object obj, String[] fieldNames) {
        //obj{"username","pwd"}-->update 表名 set username=?,pwd=? where id=?;
        Class c = obj.getClass();
        //存储sql的参数对象
        List<Object> params = new ArrayList<>();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        //获得唯一主键
        ColumnInfo priKey = tableInfo.getOnlyPriKey();
        StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");
        for (String fname:fieldNames){
            Object fvalue = ReflectUtils.invokeGet(fname,obj);
            params.add(fvalue);
            sql.append(fname + "=?,");
        }
        sql.setCharAt(sql.length()-1,' ');
        sql.append(" where ");
        sql.append(priKey.getName() + "=? ");
        //主键的值
        params.add(ReflectUtils.invokeGet(priKey.getName(),obj));
        return executeDML(sql.toString(),params.toArray());
    }

    @Override
    public List queryRows(String sql, Class clazz, Object[] params) {
        Connection connection = DBManager.getConn();
        //存放查询结果的容器
        List list = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //给sql设参
            JDBCUtils.handleParams(preparedStatement,params);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            //多行
            while (resultSet.next()){
                if (list==null){
                    list = new ArrayList();
                }
                //调用JavaBean的无参构造器
                Object rowObj = clazz.newInstance();
                //多列 select username,pwd,age from user where id>? and age>18
                for (int i=0;i<metaData.getColumnCount();i++){
                    String columnName = metaData.getColumnName(i+1);
                    Object columnValue = resultSet.getObject(i+1);
                    //调用rowObj对象的setUsername(String name)方法，将columnValue的值设置进去
                    ReflectUtils.invokeSet(rowObj,columnName,columnValue);
                }
                list.add(rowObj);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
        List list = queryRows(sql,clazz,params);
        return (list==null&&list.size()>0)?null:list.get(0);
    }

    @Override
    public Object queryValue(String sql, Object[] params) {
        Connection connection = DBManager.getConn();
        //存储查询结果的对象
        Object value = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //给sql设参
            JDBCUtils.handleParams(preparedStatement,params);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                value = resultSet.getObject(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(preparedStatement,connection);
        }
        return value;
    }

    @Override
    public Number queryNumber(String sql, Object[] params) {
        return (Number)queryValue(sql,params);
    }
}
