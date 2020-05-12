package cn.designpattern.composite;


import java.util.ArrayList;
import java.util.List;

public interface AbstrctFile {
    /**
     * 杀毒
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
        System.out.println("---图像文件：" + name + "，进行查杀！");
    }
}

class TextFile implements AbstrctFile{
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本文件：" + name + "，进行查杀！");
    }
}

class VideoFile implements AbstrctFile{
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---视频文件：" + name + "，进行查杀！");
    }
}

class Folder implements AbstrctFile{
    private String name;
    /**
     * 定义容器，用来存放本容器构建下的子节点
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
        System.out.println("---文件夹：" + name + "，进行查杀");
        for (AbstrctFile file : list){
            file.killVirus();
        }
    }
}