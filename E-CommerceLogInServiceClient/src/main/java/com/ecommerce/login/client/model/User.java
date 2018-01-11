package com.ecommerce.login.client.model;

public class User {
	
	
    private Long id;

  
    private String username;

   
    private String password;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }


}
