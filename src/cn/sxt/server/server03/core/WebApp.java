package cn.sxt.server.server03.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
    private static WebContext webContext;
    static {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            WebHandler handler = new WebHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn\\sxt\\server\\server03\\user\\web.xml"),handler);
            //获取数据
            webContext = new WebContext(handler.getEntities(),handler.getMappings());
        }catch (Exception e){
            System.out.println("解析配置文件错误");
        }
    }

    public static Servlet getServletFromUrl(String url){
        //假设你输入了/login
        String className = webContext.getClz("/" + url);
        Class clz;
        try {
            System.out.println(url + "-->" + className + "-->");
            clz = Class.forName(className);
            Servlet servlet = (Servlet) clz.getConstructor().newInstance();
            return servlet;
        }catch (Exception e){

        }
        return null;
    }
}
