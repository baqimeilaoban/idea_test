package cn.sorm.core;

/**
 * 负责Java数据类型和数据库数据类型的相互转换
 * @author 黄建波
 */
public interface TypeConvertor {
    /**
     * 将数据库数据类型转化为Java的数据类型
     * @param columnType 数据库字段的数据类型
     * @return Java的数据类型
     */
    public String databaseType2JavaType(String columnType);

    /**
     * 将Java数据类型转换为数据库数据类型
     * @param javaDataType Java数据类型
     * @return 数据库类型
     */
    public String javaType2DatabaseType(String javaDataType);
}
