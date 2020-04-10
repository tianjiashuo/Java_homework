package com;


/** @author liebes */
//id，用户名，年龄，邮箱，电话
@Table(tableName = "user")
public class User{
    @Column(columnName = "id")
    private Integer id;

    @Column(columnName = "username")
    private String username;

    @Column(columnName = "age")
    private Integer age;

    @Column(columnName = "email")
    private String email;

    @Column(columnName = "telephone")
    private String telephone;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}

