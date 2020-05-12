package cn.designpattern.facade;

/**
 * ����ע�ṫ˾���̵��������
 * @author hjb
 */
public class RegisterFacade {
    public void register(){
        IndustryCommerceBureau industryCommerceBureau = new HaiDianIndustryCommerceBureau();
        industryCommerceBureau.checkName();

        QualityInspectionBureau qualityInspectionBureau = new HaiDianQualityInspectionBureau();
        qualityInspectionBureau.orgCodeCertificate();

        TaxOffice taxOffice = new HaiDianTaxOffice();
        taxOffice.taxCertificate();

        Bank bank = new ICBC();
        bank.openAccount();
    }
}
