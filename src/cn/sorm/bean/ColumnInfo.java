package cn.sorm.bean;

/**��װ����һ���ֶε���Ϣ
 * @author �ƽ���
 */
public class ColumnInfo {
    /**
     *�ֶ�����
     */
    private String name;

    /**
     * �ֶ���������
     */
    private String dataType;

    /**
     * �ֶεļ����ͣ�0����ͨ����1��������2�������
     */
    private int keyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getKeyType() {
        return keyType;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }

    public ColumnInfo(String name, String dataType, int keyType) {
        this.name = name;
        this.dataType = dataType;
        this.keyType = keyType;
    }

    public ColumnInfo() {
    }
}
