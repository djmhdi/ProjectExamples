package com.liu.flink.streaming.datasource;

/**
 * @Auther: liudongfei
 * @Date: 2019/7/5 22:17
 * @Description:
 */
public class Student {
    private int id;
    private String name;
    private String password;
    private int age;

    public Student() {
    }

    /**
     * 全量构造器.
     * @param id id
     * @param name name
     * @param password password
     * @param age age
     */
    public Student(int id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", password='" + password + '\''
                + ", age=" + age
                + '}';
    }
}