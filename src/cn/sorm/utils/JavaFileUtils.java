package cn.sorm.utils;

import cn.sorm.bean.ColumnInfo;
import cn.sorm.bean.JavaFieldGetSet;
import cn.sorm.bean.TableInfo;
import cn.sorm.core.DBManager;
import cn.sorm.core.MysqlTypeConvertor;
import cn.sorm.core.TableContext;
import cn.sorm.core.TypeConvertor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ��װ������Java�ļ���Դ���룩���ò���
 * @author �ƽ���
 */
public class JavaFileUtils {
    /**
     * �����ֶ���Ϣ����java������Ϣ���磺varchar username --> private String username
     * @param column �ֶ���Ϣ
     * @param convertor ����ת����
     * @return java���Ժ�set/get����Դ��
     */
    public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor){
        JavaFieldGetSet jfgs = new JavaFieldGetSet();
        String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
        jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");
        //public String getUsername(){return username;}
        //����get����Դ��
        StringBuilder getSrc = new StringBuilder();
        getSrc.append("\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getName()) + "(){\n");
        getSrc.append("\t\treturn " + column.getName() + ";\n");
        getSrc.append("\t}\n");
        jfgs.setGetInfo(getSrc.toString());

        //public void setUsername(String username){this.username=username;}
        //����set����Դ��
        StringBuilder setSrc = new StringBuilder();
        setSrc.append("\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) + "(");
        setSrc.append(javaFieldType + " " + column.getName() + "){\n");
        setSrc.append("\t\tthis." + column.getName() + "=" + column.getName() + ";\n");
        setSrc.append("\t}\n");
        jfgs.setSetInfo(setSrc.toString());
        return jfgs;
    }

    /**
     * ���ݱ���Ϣ����java���Դ����
     * @param tableInfo ����Ϣ
     * @param convertor ��������ת����
     * @return java���Դ����
     */
    public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor){
        Map<String,ColumnInfo> columns = tableInfo.getColumns();
        List<JavaFieldGetSet> javaFields = new ArrayList<>();
        for (ColumnInfo c:columns.values()){
            javaFields.add(createFieldGetSetSRC(c,convertor));
        }
        StringBuilder src = new StringBuilder();
        //����package���
        src.append("package " + DBManager.getConf().getPoPackage() + ";\n\n");
        //����import���
        src.append("import java.sql.*;\n");
        src.append("import java.util.*;\n\n");
        //�������������
        src.append("public class " + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + " {\n\n");
        //���������б�
        for (JavaFieldGetSet f:javaFields){
            src.append(f.getFieldInfo());
        }
        src.append("\n\n");
        //��get�����б�
        for (JavaFieldGetSet f:javaFields){
            src.append(f.getGetInfo());
        }
        //����set�����б�
        for (JavaFieldGetSet f:javaFields){
            src.append(f.getSetInfo());
        }
        //���������
        src.append("}\n");
        return src.toString();
    }

    public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor){
        String src = createJavaSrc(tableInfo,convertor);
        String srcPath = DBManager.getConf().getSrcPath() + "\\";
        String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.","/");
        File f = new File(srcPath + packagePath);
        System.out.println(f.getAbsolutePath());
        //���ָ��Ŀ¼�����ڣ�������û�����
        if (!f.exists()){
            f.mkdirs();
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile() + "/" + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java"));
            bw.write(src);
            System.out.println("������" + tableInfo.getTname() + "��Ӧ��java�ࣺ" + StringUtils.firstChar2UpperCase(tableInfo.getTname() + ".java"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw!=null){
                    bw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        /*ColumnInfo ci = new ColumnInfo("id","int",0);
        JavaFieldGetSet f = createFieldGetSetSRC(ci,new MysqlTypeConvertor());
        System.out.println(f);*/

        Map<String,TableInfo> map = TableContext.tables;
        for (TableInfo t:map.values()){
            createJavaPOFile(t,new MysqlTypeConvertor());
        }

    }
}
