package cn.sxt.thread.thread01;

import java.util.concurrent.*;

/**
 * 了解创建线程的方式三
 * @author 黄建波
 */
public class CDownloader implements Callable {
    private String url;
    private String name;

    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        WebDownloader web = new WebDownloader();
        web.download(url,name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader cDownloader1 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586259241139&di=1826bf1975e0f9ef1ddd16ea6383cf0c&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F3c6d55fbb2fb43163bc6904622a4462309f7d335.jpg","p1.jpg");
        CDownloader cDownloader2 = new CDownloader("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3210272353,5260557&fm=26&gp=0.jpg","p2.jpg");
        CDownloader cDownloader3 = new CDownloader("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1965879306,1070364340&fm=26&gp=0.jpg","p3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行服务
        Future<Boolean> result1 = ser.submit(cDownloader1);
        Future<Boolean> result2 = ser.submit(cDownloader2);
        Future<Boolean> result3 = ser.submit(cDownloader3);
        //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println(r3);
        //关闭服务
        ser.shutdownNow();
    }
}
