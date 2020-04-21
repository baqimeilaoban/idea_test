package thread.thread01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载图片
 *
 * @author 黄建波
 */
public class WebDownloader {
    /**
     * 下载图片
     * @param url 地址
     * @param name 图片名称
     */
    public void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("不合法的路劲");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("图片下载失败");
        }
    }
}
