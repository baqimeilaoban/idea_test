package cn.sxt.io3;

import java.io.*;

/**
 * �ļ��������ļ��ֽ����롢����� �������ڴ��ı���
 * @author �ƽ���
 */
public class CopyTest {
    public static void main(String[] args) {
        copy("abc-copy.txt","abc-copy1.txt");
    }

    public static void copy(String srcPath,String destPath){
        //����Դ
        File src = new File(srcPath);
        File dest = new File(destPath);
        //ѡ����
        try(BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {
            //����
            String line = null;
            while ((line=br.readLine()) != null){
                //����д��
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
