package cn.designpattern.composite;

public class Client {
    public static void main(String[] args) {
        AbstrctFile f2,f3,f4,f5;
        Folder f1 = new Folder("�ҵ��ղ�");
        f2 = new ImageFile("�ϸߵĴ�ͷ��.jpg");
        f3 = new TextFile("Hello.txt");
        f1.add(f2);
        f1.add(f3);

        Folder f11 = new Folder("��Ӱ");
        f4 = new VideoFile("Ц������.avi");
        f5 = new VideoFile("�������.avi");
        f11.add(f4);
        f11.add(f5);
        f1.add(f11);
        f1.killVirus();
    }
}
