package thread.thread01;

/**
 * lambda推到 + 参数
 * @author 黄建波
 */
public class LambdaTest02 {
    public static void main(String[] args) {
        Ilove love = (int a) -> {
            System.out.println("i like lambda -->" + a);
        };
        love.lambda(100);

        //简化
        love = (a) ->{
            System.out.println("i like lambda -->" + a);
        };
        love.lambda(50);

        love = a -> {
            System.out.println("i like lambda -->" + a);
        };
        love.lambda(5);

        love = a -> System.out.println("i like lambda -->" +a);
        love.lambda(0);
    }
}

interface Ilove{
    void lambda(int a);
}

class Love implements Ilove{

    @Override
    public void lambda(int a) {
        System.out.println("i like lambda -->" + a);
    }
}