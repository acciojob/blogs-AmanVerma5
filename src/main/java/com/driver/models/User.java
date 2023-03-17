package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName="test";
    private String lastName="test";
    private String Username;
    private String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> blogList=new ArrayList<>();




    public User(){
    }

    public User(int id, String firstName, String lastName, String userName, String password,List<Blog> blogList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Username = userName;
        this.password = password;
        this.blogList = blogList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String userName) {
        this.Username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}