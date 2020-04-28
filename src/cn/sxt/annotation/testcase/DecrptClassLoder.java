package cn.sxt.annotation.testcase;

import java.io.*;

/**
 * ��������ϵͳ�м��ܺ��class�ֽ�����������
 * @author hjb
 */
public class DecrptClassLoder extends ClassLoader{
    private String rootDir;

    public DecrptClassLoder(String rootDir) {
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
            int temp = -1;
            while ((temp=is.read())!=-1){
                //ȡ������
                baos.write(temp^0xff);
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
