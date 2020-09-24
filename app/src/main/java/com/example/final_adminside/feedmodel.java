package com.example.final_adminside;

public class feedmodel {
    String name2, emil2, msg2;

    public feedmodel(){

    }

    public feedmodel(String name, String msg, String mail) {
        this.name2 = name;
        this.emil2 = msg;
        this.msg2 = mail;
    }

    public void setName(String name) {
        this.name2 = name;
    }

    public void setMsg(String msg) {
        this.msg2 = msg;
    }

    public void setMail(String mail) {
        this.emil2 = mail;
    }

    public String getName() {
        return name2;
    }

    public String getMsg() {
        return msg2;
    }

    public String getMail() {
        return emil2;
    }
}
