package cn.designpattern.facade;

public interface QualityInspectionBureau {
    void orgCodeCertificate();
}

class HaiDianQualityInspectionBureau implements QualityInspectionBureau{

    @Override
    public void orgCodeCertificate() {
        System.out.println("�ں������ʼ�ְ�����֯��������֤��");
    }
}
