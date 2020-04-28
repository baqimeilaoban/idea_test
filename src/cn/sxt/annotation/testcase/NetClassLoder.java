package cn.sxt.annotation.testcase;

import java.io.*;
import java.net.URL;

/**
 * 自定义文件系统类加载器
 * @author hjb
 */
public class NetClassLoder extends ClassLoader{
    private String rootUrl;

    public NetClassLoder(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        Class<?> c = findLoadedClass(name);
        //应该查询有没有加载这个类。如果已经加载，则直接返回加载好的类。如果没有，则加载新的类
        if (c!=null){
            return c;
        }else {
            ClassLoader parent = this.getParent();
            //委派给父类加载
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
        String path = rootUrl + "/" + classname.replace('.','/') + ".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URL url = new URL(path);
            is = url.openStream();
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
