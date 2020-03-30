package cn.sxt.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * д������
 * @author �ƽ���
 */
public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        //д���ļ�
        FileUtils.write(new File("src/cn/sxt/commons/happy.txt"),
                "ѧϰ��һ��ΰ�����ҵ\r\n","GBK");
        FileUtils.writeStringToFile(new File("src/cn/sxt/commons/happy.txt"),
                "ѧϰ��һ�����ֵ���\r\n","GBK",true);
        FileUtils.writeByteArrayToFile(new File("src/cn/sxt/commons/happy.txt"),
                "ѧϰ��һ�����������\r\n".getBytes("GBK"),true);

        //д���б�
        List<String> datas = new ArrayList<String>();
        datas.add("����");
        datas.add("����");
        datas.add("������");
        FileUtils.writeLines(new File("src/cn/sxt/commons/happy.txt")
                ,datas,".....",true);

    }
}
