package cn.sxt.server.server02;

public class RegisterServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        response.print("registration success");
    }
}
