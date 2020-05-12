package cn.designpattern.state;

/**
 * 已预定状态
 * @author 黄建波
 */
public class BookedState implements State{
    @Override
    public void handle() {
        System.out.println("房间已预定！别人不能定！");
    }
}
