package cn.designpattern.facade;

public interface IndustryCommerceBureau {
    void checkName();
}

class HaiDianIndustryCommerceBureau implements IndustryCommerceBureau{

    @Override
    public void checkName() {
        System.out.println("检查名字是否有冲突！");
    }
}
