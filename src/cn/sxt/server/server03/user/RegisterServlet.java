package cn.sxt.server.server03.user;


import cn.sxt.server.server03.core.Request;
import cn.sxt.server.server03.core.Response;
import cn.sxt.server.server03.core.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        //��עҵ���߼�
        String uname = request.getParameter("uname");
        String[] favs = request.getParameterValues("fav");
        response.print("<html>");
        response.print("<head>");
        response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=gbk\">" );
        response.print("<title>");
        response.print("ע��ɹ�");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.println("��ע�����ϢΪ:" + uname);
        response.println("��ϲ��������Ϊ��");
        for (String v:favs){
            if ("0".equals(v)){
                response.print("������");
            }else if ("1".equals(v)){
                response.print("������");
            }else if ("2".equals(v)){
                response.print("���ý�Լ��");
            }
        }
        response.print("</body>");
        response.print("</html>");
    }
}
