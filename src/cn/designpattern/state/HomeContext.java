package cn.designpattern.state;

/**
 * 房间对象
 * @author 黄建波
 */
public class HomeContext {
    private State state;

    public void setState(State state) {
        System.out.println("修改状态");
        this.state = state;
        state.handle();
    }
}
