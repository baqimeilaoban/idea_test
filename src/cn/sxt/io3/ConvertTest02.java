package cn.sxt.io3;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * ת������InputStreamReader OutputStreamWriter
 * 1.���ַ�������ʽ�����ֽ���
 * 2.ָ���ַ���
 * @author �ƽ���
 */
public class ConvertTest02 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),StandardCharsets.UTF_8))){
            String msg;
            while ((msg=reader.readLine())!=null){
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();
        }catch (IOException e) {
            System.out.println("�����쳣");
        }
    }

    /**
     * �������������жԱ�
     */
    public static void test1(){
        //���������� ���ذٶȵ�Դ����
        try(InputStream is = new URL("http://www.baidu.com").openStream();) {
            int temp;
            while ((temp=is.read())!=-1){
                System.out.print((char)temp);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * �������������жԱ�
     */
    public static void test2(){
        //���������� ���ذٶȵ�Դ����
        try(InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(), StandardCharsets.UTF_8)) {
            //����
            int temp;
            while ((temp=is.read())!=-1){
                System.out.print((char)temp);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
