package thread.thread01;

public class TDownloader extends Thread{
    /**
     * 远程路径
     */
    private String url;

    /**
     * 存储名字
     */
    private String name;

    public TDownloader(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
    }

    public static void main(String[] args) {
        TDownloader td1 = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586259241139&di=1826bf1975e0f9ef1ddd16ea6383cf0c&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F3c6d55fbb2fb43163bc6904622a4462309f7d335.jpg","p1.jpg");
        TDownloader td2 = new TDownloader("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3210272353,5260557&fm=26&gp=0.jpg","p2.jpg");
        TDownloader td3 = new TDownloader("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1965879306,1070364340&fm=26&gp=0.jpg","p3.jpg");

        //启动三个线程
        td1.start();
        td2.start();
        td3.start();
    }
}
