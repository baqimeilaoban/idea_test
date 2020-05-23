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
 * �����ȡ�������ݿ���Ҫ��ṹ����ṹ�Ĺ�ϵ�������Ը��ݱ�ṹ������ṹ
 * @author �ƽ���
 */
public class TableContext {
    /**
     * ����Ϊkey������Ϣ����Ϊvalue
     */
    public static Map<String, TableInfo> tables = new HashMap<String, TableInfo>();

    /**
     * ��po��class����ͱ���Ϣ���������������������
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
                //��ѯ���е������ֶ�
                ResultSet set = dbmd.getColumns(null,"%",tableName,"%");
                while (set.next()){
                    ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),set.getString("TYPE_NAME"),0);
                    ti.getColumns().put(set.getString("COLUMN_NAME"),ci);
                }

                //��ѯ���ݱ��е�����
                ResultSet set2 = dbmd.getPrimaryKeys(null,"%",tableName);
                while (set2.next()){
                    ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
                    //��Ϊ��������
                    ci2.setKeyType(1);
                    ti.getPriKeys().add(ci2);
                }

                //ȡΨһ����������ʹ�ã������������������Ϊ��
                if (ti.getPriKeys().size()>0){
                    ti.setOnlyPriKey(ti.getPriKeys().get(0));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //������ṹ
        updateJavaPOFile();

        //����po�����������࣬�������ã����Ч��
        loadPOTables();
    }

    /**
     * ����po���������
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
     * ���ݱ�ṹ���������õ�po�����java��
     * ʵ���˴ӱ�ṹת������ṹ
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
