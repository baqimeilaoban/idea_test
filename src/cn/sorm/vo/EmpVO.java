package cn.sorm.vo;

public class EmpVO {
    private Integer id;
    private String empname;
    private Double xinshui;
    private Integer age;
    private String dname;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Double getXinshui() {
        return xinshui;
    }

    public void setXinshui(Double xinshui) {
        this.xinshui = xinshui;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmpVO(Integer id, String empname, Double xinshui, Integer age, String dname, String address) {
        this.id = id;
        this.empname = empname;
        this.xinshui = xinshui;
        this.age = age;
        this.dname = dname;
        this.address = address;
    }

    public EmpVO() {
    }
}
