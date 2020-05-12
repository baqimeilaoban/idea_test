package cn.designpattern.composite;


import java.util.ArrayList;
import java.util.List;

public interface AbstrctFile {
    /**
     * ɱ��
     */
    void killVirus();
}

class ImageFile implements AbstrctFile{
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---ͼ���ļ���" + name + "�����в�ɱ��");
    }
}

class TextFile implements AbstrctFile{
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---�ı��ļ���" + name + "�����в�ɱ��");
    }
}

class VideoFile implements AbstrctFile{
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---��Ƶ�ļ���" + name + "�����в�ɱ��");
    }
}

class Folder implements AbstrctFile{
    private String name;
    /**
     * ����������������ű����������µ��ӽڵ�
     */
    private List<AbstrctFile> list = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstrctFile file){
        list.add(file);
    }

    public void remove(AbstrctFile file){
        list.remove(file);
    }

    public AbstrctFile getChild(int index){
        return list.get(index);
    }
    @Override
    public void killVirus() {
        System.out.println("---�ļ��У�" + name + "�����в�ɱ");
        for (AbstrctFile file : list){
            file.killVirus();
        }
    }
}