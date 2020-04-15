package cn.sxt.thread.thread01;

/**
 * Lambda�Ƶ�
 * @author thinkpad
 */
public class LambdaTest01 {
    //�ڲ���
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        //�����ڲ���
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        //lambda
        like = () -> {
            System.out.println("i like lambda5");
        };
        like.lambda();

        /*
		 *lambda�Ƶ������������
		()-> {
			System.out.println("i like lambda5 ");
		}.lambda();
		*/
    }
}

interface ILike{
    void lambda();
}

//�ⲿ��
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}