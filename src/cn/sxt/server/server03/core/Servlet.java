package cn.sxt.server.server03.core;

/**
 * 服务器小脚本
 * @author 黄建波
 */
public interface Servlet {
    void service(Request request, Response response);
}
