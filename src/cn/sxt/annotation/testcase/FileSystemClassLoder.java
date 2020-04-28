package cn.sxt.annotation.testcase;

import java.io.*;

/**
 * �Զ����ļ�ϵͳ�������
 * @author hjb
 */
public class FileSystemClassLoder extends ClassLoader{
    private String rootDir;

    public FileSystemClassLoder(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        Class<?> c = findLoadedClass(name);
        //Ӧ�ò�ѯ��û�м�������ࡣ����Ѿ����أ���ֱ�ӷ��ؼ��غõ��ࡣ���û�У�������µ���
        if (c!=null){
            return c;
        }else {
            ClassLoader parent = this.getParent();
            //ί�ɸ��������
            c = parent.loadClass(name);
            if (c!=null){
                return c;
            }else {
                byte[] classData = getClassData(name);
                if (classData==null){
                    throw new ClassNotFoundException();
                }else {
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassData(String classname) {
        String path = rootDir + "/" + classname.replace('.','/') + ".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp=is.read(buffer))!=-1){
                baos.write(buffer,0,temp);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
                try {
                    if (is!=null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (baos!=null){
                        baos.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
        }

    }


}
