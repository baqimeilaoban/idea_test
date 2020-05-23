package cn.sorm.core;

import cn.sorm.bean.ColumnInfo;
import cn.sorm.bean.TableInfo;
import cn.sorm.utils.JavaFileUtils;
import cn.sorm.utils.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责获取管理数据库所要表结构和类结构的关系，并可以根据表结构生成类结构
 * @author 黄建波
 */
public class TableContext {
    /**
     * 表名为key，表信息对象为value
     */
    public static Map<String, TableInfo> tables = new HashMap<String, TableInfo>();

    /**
     * 将po的class对象和表信息对象关联起来，便于重用
     */
    public static Map<Class,TableInfo> poClassTableMap = new HashMap<>();

    private TableContext(){
    }

    static {
        try {
            Connection connection = DBManager.getConn();
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet tableRet = dbmd.getTables(null,"%","%",new String[]{"TABLE"});
            while (tableRet.next()){
                String tableName = (String) tableRet.getObject("TABLE_NAME");
                TableInfo ti = new TableInfo(tableName,new HashMap<String,ColumnInfo>(),new ArrayList<ColumnInfo>());
                tables.put(tableName,ti);
                //查询表中的所有字段
                ResultSet set = dbmd.getColumns(null,"%",tableName,"%");
                while (set.next()){
                    ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),set.getString("TYPE_NAME"),0);
                    ti.getColumns().put(set.getString("COLUMN_NAME"),ci);
                }

                //查询数据表中的主键
                ResultSet set2 = dbmd.getPrimaryKeys(null,"%",tableName);
                while (set2.next()){
                    ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
                    //设为主键类型
                    ci2.setKeyType(1);
                    ti.getPriKeys().add(ci2);
                }

                //取唯一主键，方便使用，如果是联合主键，则为空
                if (ti.getPriKeys().size()>0){
                    ti.setOnlyPriKey(ti.getPriKeys().get(0));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //更新类结构
        updateJavaPOFile();

        //加载po包下面所有类，便于重用，提高效率
        loadPOTables();
    }

    /**
     * 加载po包下面的类
     */
    private static void loadPOTables() {
        for (TableInfo tableInfo:tables.values()){
            try {
                Class c = Class.forName(DBManager.getConf().getPoPackage() + "." + StringUtils.firstChar2UpperCase(tableInfo.getTname()));
                poClassTableMap.put(c,tableInfo);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 根据表结构，更新配置的po下面的java类
     * 实现了从表结构转换到类结构
     */
    private static void updateJavaPOFile() {
        Map<String,TableInfo> map = TableContext.tables;
        for (TableInfo t:map.values()){
            JavaFileUtils.createJavaPOFile(t,new MysqlTypeConvertor());
        }
    }

    public static void main(String[] args) {
        Map<String,TableInfo> tables = TableContext.tables;
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println(tables);
    }

}
