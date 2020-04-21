package cn.sxt.server.server03.user;


import cn.sxt.server.server03.core.Request;
import cn.sxt.server.server03.core.Response;
import cn.sxt.server.server03.core.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        //关注业务逻辑
        String uname = request.getParameter("uname");
        String[] favs = request.getParameterValues("fav");
        response.print("<html>");
        response.print("<head>");
        response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=gbk\">" );
        response.print("<title>");
        response.print("注册成功");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.println("你注册的信息为:" + uname);
        response.println("你喜欢的类型为：");
        for (String v:favs){
            if ("0".equals(v)){
                response.print("萝莉型");
            }else if ("1".equals(v)){
                response.print("豪放型");
            }else if ("2".equals(v)){
                response.print("经济节约型");
            }
        }
        response.print("</body>");
        response.print("</html>");
    }
}
