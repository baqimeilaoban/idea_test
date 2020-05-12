package cn.designpattern.flyweight;

/**
 * ��Ԫ��
 * @author hjb
 */
public interface ChessFlyWeight {
    void setColor(String c);
    String getColor();
    void display(Coordinate c);
}

class ConcreteChess implements ChessFlyWeight{
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String c) {
        this.color = c;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("������ɫ��" + color);
        System.out.println("����λ�ã�" + c.getX() + "----" + c.getY());
    }
}
