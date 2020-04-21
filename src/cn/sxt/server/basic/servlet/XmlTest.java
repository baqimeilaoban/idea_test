package cn.sxt.server.basic.servlet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 熟悉SAX解析流程
 * @author 黄建波
 */
public class XmlTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        WebHandler handler = new WebHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn\\sxt\\server\\basic\\servlet\\web.xml"),handler);
        //获取数据
        WebContext context = new WebContext(handler.getEntities(),handler.getMappings());
        //假设你输入了/login
        String className = context.getClz("/login");
        Class clz = Class.forName(className);
        Servlet servlet = (Servlet)clz.getConstructor().newInstance();
        System.out.println(servlet);
        servlet.service();
    }
}

class WebHandler extends DefaultHandler{
    private List<Entity> entities = new ArrayList<>();
    private List<Mapping> mappings = new ArrayList<>();
    private Entity entity;
    private Mapping mapping;
    private String tag;
    private boolean isMapping = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName!=null){
            tag = qName;
            if (tag.equals("servlet")){
                entity = new Entity();
                isMapping = false;
            }else if (tag.equals("servlet-mapping")){
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length).trim();
        if (null!=tag){
            //处理servlet-mapping
            if (isMapping){
                if (tag.equals("servlet-name")){
                    mapping.setName(contents);
                }else if (tag.equals("url-pattern")){
                    mapping.addPattern(contents);
                }
            }else {
                //操作servlet
                if (tag.equals("servlet-name")){
                    entity.setName(contents);
                }else if (tag.equals("servlet-class")){
                    entity.setClz(contents);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (null!=qName){
            if (qName.equals("servlet")){
                entities.add(entity);
            }else if (qName.equals("servlet-mapping")){
                mappings.add(mapping);
            }
        }
        tag = null;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }
}