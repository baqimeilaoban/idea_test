package cn.designpattern.facade;

public interface IndustryCommerceBureau {
    void checkName();
}

class HaiDianIndustryCommerceBureau implements IndustryCommerceBureau{

    @Override
    public void checkName() {
        System.out.println("��������Ƿ��г�ͻ��");
    }
}
