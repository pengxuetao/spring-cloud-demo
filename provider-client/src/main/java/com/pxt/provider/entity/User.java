package com.pxt.provider.entity;

/**
 * @author Peng xue-tao
 * @since 2020/8/10
 */
public class User {

    private String id;

    private String userName;

    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
