package cn.designpattern.facade;

public interface TaxOffice {
    void taxCertificate();
}

class HaiDianTaxOffice implements TaxOffice{
    @Override
    public void taxCertificate() {
        System.out.println("�ں���˰��ְ���˰��Ǽ�֤��");
    }
}
