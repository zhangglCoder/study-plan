package cn.zpro.study.compare;

import java.util.Date;

/**
 * Created by dell on 2017/8/14.
 */
public class User {
    private String name;
    private Date createTime;
    private int age;

    public User(String name, Date createTime, int age) {
        this.name = name;
        this.createTime = createTime;
        this.age = age;
    }

    public User() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                ", age=" + age +
                '}';
    }
}
