package cn.designpattern.state;

/**
 * 已入住状态
 * @author 黄建波
 */
public class CheckedInState implements State{
    @Override
    public void handle() {
        System.out.println("房间已入住！请勿打扰！");
    }
}
