package cn.sxt.annotation.dynamiccompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,"D:\\idea-workspace\\src\\cn\\sxt\\annotation\\dynamiccompile\\HelloWorld.java");
        System.out.println(result==0?"����ɹ�":"����ʧ��");

        //ͨ��Runtime����ִ����
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp D:/idea-workspace/src/cn/sxt/annotation/dynamiccompile   HelloWorld");
        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String info;
        while ((info = reader.readLine())!=null){
            System.out.println(info);
        }

        try {
            URL[] urls = new URL[]{new URL("file:/" + "D:/idea-workspace/src/cn/sxt/annotation/dynamiccompile/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class<?> c = loader.loadClass("HelloWorld");
            //���ü�����ĵ�main����
            Method m = c.getMethod("main",String[].class);
            m.invoke(null,(Object)new String[]{});
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
