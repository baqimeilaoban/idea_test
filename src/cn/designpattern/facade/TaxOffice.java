package cn.designpattern.facade;

public interface TaxOffice {
    void taxCertificate();
}

class HaiDianTaxOffice implements TaxOffice{
    @Override
    public void taxCertificate() {
        System.out.println("在海淀税务局办理税务登记证！");
    }
}
