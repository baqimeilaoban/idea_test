package cn.designpattern.facade;

public interface QualityInspectionBureau {
    void orgCodeCertificate();
}

class HaiDianQualityInspectionBureau implements QualityInspectionBureau{

    @Override
    public void orgCodeCertificate() {
        System.out.println("在海淀区质检局办理组织机构代码证！");
    }
}
