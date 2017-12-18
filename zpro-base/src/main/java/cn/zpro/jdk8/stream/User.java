package cn.zpro.jdk8.stream;

import java.util.Date;

/**
 * @author zhanggl
 */
public class User {


    public User(Integer id, String name, Date createTime, Integer pid) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.pid = pid;
    }

    private Integer id;
    private String name;
    private Date createTime;
    private Integer pid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", pid=" + pid +
                '}';
    }
}
