package cn.sxt.server.server01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * ��װ����Э�飺��ȡmethod uri�Լ��������
 * @author �ƽ���
 */
public class Request01 {
    /**
     * Э����Ϣ
     */
    private String requestInfo;
    /**
     * ����ʽ
     */
    private String method;
    /**
     * ����url
     */
    private String url;
    /**
     * �������
     */
    private String queryStr;
    private final String CRLF = "\r\n";

    public Request01(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request01(InputStream is){
        byte[] datas = new byte[1024*1024];
        int len;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas,0,len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //�ֽ��ַ���
        parseRequestInfo();
    }

    private void parseRequestInfo() {
        System.out.println("---�ֽ�---");
        System.out.println("---1.��ȡ����ʽ����ͷ����һ��/---");
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase();
        this.method = this.method.trim();
        System.out.println("---2.��ȡ����url����һ��/ �� HTTP/---");
        System.out.println("---���ܰ���������ǰ���Ϊurl---");
        //1����ȡ/��λ��
        int startIndex = this.requestInfo.indexOf("/") + 1;
        //2����ȡHTTP/��λ��
        int endIndex = this.requestInfo.indexOf("HTTP/");
        //3���ָ��ַ���
        this.url = this.requestInfo.substring(startIndex,endIndex);
        //4����ȡ����λ��
        int queryIndex = this.url.indexOf("?");
        if (queryIndex>=0){
            //��ʾ�����������
            String[] urlArry = this.url.split("\\?");
            this.url = urlArry[0];
            queryStr = urlArry[1];
        }
        System.out.println(this.url);

        System.out.println("---3.��ȡ������������GET�Ѿ���ȡ�������POST��������������---");

        if (method.equals("post")){
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            System.out.println(qStr + "-->");
            if (null==queryStr){
                queryStr = qStr;
            }else {
                queryStr += "&" + qStr;
            }
        }
        queryStr = null==queryStr?"":queryStr;
        System.out.println(method + "-->" + url + "-->" + queryStr);
    }

}
