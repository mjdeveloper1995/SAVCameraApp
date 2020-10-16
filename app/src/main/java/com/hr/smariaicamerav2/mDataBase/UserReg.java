package com.hr.smariaicamerav2.mDataBase;

public class UserReg {
    int user_id;
    String fullname;
    String emails;
    String username;
    String password;
    String imeino;
    Long phones;
    String createcode;
    String createdon;

    public UserReg(int user_id, String fullname, String emails, String username, String password, String imeino, Long phones, String createcode, String createdon) {
        this.user_id = user_id;
        this.fullname = fullname;
        this.emails = emails;
        this.username = username;
        this.password = password;
        this.imeino = imeino;
        this.phones = phones;
        this.createcode = createcode;
        this.createdon = createdon;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

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

    public String getImeino() {
        return imeino;
    }

    public void setImeino(String imeino) {
        this.imeino = imeino;
    }

    public Long getPhones() {
        return phones;
    }

    public void setPhones(Long phones) {
        this.phones = phones;
    }

    public String getCreatecode() {
        return createcode;
    }

    public void setCreatecode(String createcode) {
        this.createcode = createcode;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }
}
