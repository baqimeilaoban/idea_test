package thread.thread01;

/**
 * @author thinkpad
 */
public class IDownloader implements Runnable{
    private String url;
    private String name;

    public IDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
    }

    public static void main(String[] args) {
        IDownloader iDownloader1 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586259241139&di=1826bf1975e0f9ef1ddd16ea6383cf0c&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F3c6d55fbb2fb43163bc6904622a4462309f7d335.jpg","p1.jpg");
        IDownloader iDownloader2 = new IDownloader("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3210272353,5260557&fm=26&gp=0.jpg","p2.jpg");
        IDownloader iDownloader3 = new IDownloader("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1965879306,1070364340&fm=26&gp=0.jpg","p3.jpg");

        //启动三个线程
        new Thread(iDownloader1).start();
        new Thread(iDownloader2).start();
        new Thread(iDownloader3).start();
    }
}
