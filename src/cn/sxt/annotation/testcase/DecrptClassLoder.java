package cn.sxt.annotation.testcase;

import java.io.*;

/**
 * 加载文字系统中加密后的class字节码的类加载器
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
        String path = rootDir + "/" + classname.replace('.','/') + ".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            int temp = -1;
            while ((temp=is.read())!=-1){
                //取反操作
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
