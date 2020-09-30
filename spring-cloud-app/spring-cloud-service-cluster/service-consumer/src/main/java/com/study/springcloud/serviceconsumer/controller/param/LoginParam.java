package com.study.springcloud.serviceconsumer.controller.param;

public class LoginParam {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginParam{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
