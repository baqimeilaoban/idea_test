package cn.designpattern.builder;

public class SxtAirShipBuilder implements AirShipBuilder{
    @Override
    public Engine builderEngine() {
        System.out.println("构建尚学堂牌发动机！");
        return new Engine("尚学堂牌发动机！");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建轨道舱！");
        return new OrbitalModule("尚学堂牌轨道舱！");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建逃逸塔！");
        return new EscapeTower("尚学堂牌逃逸塔！");
    }
}
