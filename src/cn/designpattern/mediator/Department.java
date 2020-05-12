package cn.designpattern.mediator;

/**
 * 同事类的接口
 * @author 黄建波
 */
public interface Department {
    /**
     * 做本部门的事情
     */
    void selfAction();
    /**
     * 向总经理发出申请
     */
    void outAction();
}
