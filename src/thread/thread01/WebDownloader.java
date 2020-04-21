package thread.thread01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ����ͼƬ
 *
 * @author �ƽ���
 */
public class WebDownloader {
    /**
     * ����ͼƬ
     * @param url ��ַ
     * @param name ͼƬ����
     */
    public void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("���Ϸ���·��");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("ͼƬ����ʧ��");
        }
    }
}
