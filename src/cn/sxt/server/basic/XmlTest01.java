package cn.sxt.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * 熟悉SAX解析流程 流解析
 * @author 黄建波
 */
public class XmlTest01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //加载文档Document注册处理器
        //编写处理器
        PHandler handler=new PHandler();
        //5.解析
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/sxt/server/basic/p.xml"),handler);
    }
}

class PHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("----解析文档开始----");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "-->解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String contents = new String(ch,start,length).trim();
        if (contents.length()>0){
            System.out.println("内容为->" + contents);
        }else {
            System.out.println("内容为空");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析开始结束");
    }

    @Override
    public void endDocument() {
        System.out.println("----解析文档结束----");
    }
}
