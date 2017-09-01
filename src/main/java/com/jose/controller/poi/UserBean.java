package com.jose.controller.poi;

/**
 * 测试导出Excel的UserBean
 */
public class UserBean {

    @ExcelColumnAnnotation(index = 0, name = "用户名")
    private String name;

    @ExcelColumnAnnotation(index = 1, name = "用户年龄")
    private String age;

    @ExcelColumnAnnotation(index = 2, name = "用户性别")
    private String sex;

    public UserBean(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
