package cn.designpattern.builder;

public class SxtAirShipBuilder implements AirShipBuilder{
    @Override
    public Engine builderEngine() {
        System.out.println("������ѧ���Ʒ�������");
        return new Engine("��ѧ���Ʒ�������");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("��������գ�");
        return new OrbitalModule("��ѧ���ƹ���գ�");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("������������");
        return new EscapeTower("��ѧ������������");
    }
}
