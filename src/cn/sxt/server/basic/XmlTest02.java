package cn.sxt.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlTest02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1.��ȡ��������
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.�ӽ���������ȡ������
        SAXParser parser = factory.newSAXParser();
        //3.��д������
        //4.�����ĵ� Document ע�ᴦ����
        PersonHandler handler = new PersonHandler();
        //5.����
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn\\sxt\\server\\basic\\p.xml"),handler);
        //��ȡ����
        List<Person> persons = handler.getPersons();
        for (Person p:persons){
            System.out.println(p.getName() + "-->" + p.getAge());
        }
    }
}

class PersonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    /**
     * �洢������ǩ
     */
    private String tag;

    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (null!=qName){
            //�洢��ǩ��
            tag = qName;
            if (tag.equals("person")){
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length).trim();
        //�����˿�
        if (null!=tag){
            if (tag.equals("name")){
                person.setName(contents);
            }else if (tag.equals("age")){
                if (contents.length()>0){
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (null!=qName){
            if (qName.equals("person")){
                persons.add(person);
            }
        }
        //tag������
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {

    }

    public List<Person> getPersons() {
        return persons;
    }
}
