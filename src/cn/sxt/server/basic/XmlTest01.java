package cn.sxt.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * ��ϤSAX�������� ������
 * @author �ƽ���
 */
public class XmlTest01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX����
        //1.��ȡ��������
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.�ӽ���������ȡ������
        SAXParser parse = factory.newSAXParser();
        //�����ĵ�Documentע�ᴦ����
        //��д������
        PHandler handler=new PHandler();
        //5.����
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/sxt/server/basic/p.xml"),handler);
    }
}

class PHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("----�����ĵ���ʼ----");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "-->������ʼ");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String contents = new String(ch,start,length).trim();
        if (contents.length()>0){
            System.out.println("����Ϊ->" + contents);
        }else {
            System.out.println("����Ϊ��");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->������ʼ����");
    }

    @Override
    public void endDocument() {
        System.out.println("----�����ĵ�����----");
    }
}
