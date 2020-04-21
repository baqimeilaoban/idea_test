package cn.sxt.server.server02;

public class OtherServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        response.print("Other test pages");
    }
}
