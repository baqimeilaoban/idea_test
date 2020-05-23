package cn.sorm.core;

/**
 * ����Java�������ͺ����ݿ��������͵��໥ת��
 * @author �ƽ���
 */
public interface TypeConvertor {
    /**
     * �����ݿ���������ת��ΪJava����������
     * @param columnType ���ݿ��ֶε���������
     * @return Java����������
     */
    public String databaseType2JavaType(String columnType);

    /**
     * ��Java��������ת��Ϊ���ݿ���������
     * @param javaDataType Java��������
     * @return ���ݿ�����
     */
    public String javaType2DatabaseType(String javaDataType);
}
