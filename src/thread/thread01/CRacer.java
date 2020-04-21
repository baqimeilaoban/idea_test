package thread.thread01;

import java.util.concurrent.*;

/**
 * 模拟龟兔赛跑
 * @author 黄建波
 */
public class CRacer implements Callable {
    private String winner;

    @Override
    public Integer call() throws Exception {
        for (int steps = 1;steps <= 100; steps++){
            //模拟休息
            if (Thread.currentThread().getName().equals("pool-1-thread-1") && steps%10==0){
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName()+"--->" + steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if (flag){
                return steps;
            }
        }
        return null;
    }

    private boolean gameOver(int steps) {
        //存在胜利者
        if (winner!=null){
            return true;
        }else {
            if (steps==100){
                winner=Thread.currentThread().getName();
                System.out.println("winner==>" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();
        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> result1 = service.submit(racer);
        Future<Integer> result2 = service.submit(racer);
        //获取结果
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1 + "--->" + r2);
        //关闭服务
        service.shutdownNow();
    }
}
