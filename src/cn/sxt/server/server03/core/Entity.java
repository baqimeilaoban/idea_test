package cn.sxt.server.server03.core;

/**
 * <servlet>
 *  <servlet-name>login</servlet-name>
 *  <servlet-class>com.shsxt.LoginServlet</servlet-class>
 * </servlet>
 * @author »Æ½¨²¨
 */
public class Entity {
    private String name;
    private String clz;

    public Entity(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}
