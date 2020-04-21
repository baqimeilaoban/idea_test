package cn.sxt.server.server02;

public class LoginServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("the first servlet");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("Welcome back:" + request.getParameter("uname"));
        response.print("</body>");
        response.print("</html>");
    }
}
