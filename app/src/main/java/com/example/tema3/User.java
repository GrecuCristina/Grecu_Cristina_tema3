package com.example.tema3;

public class User {


    private int id;
    private String name;
    private String username;
    private String email;


   public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public User(int id,String name, String username, String email)
    {

      this.name=name;
      this.id=id;
      this.username=username;
      this.email=email;

    }
    public User(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
