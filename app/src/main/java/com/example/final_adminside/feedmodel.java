package com.example.final_adminside;

public class feedmodel {
    String name2, emil2, msg2;

    public feedmodel(){

    }

    public feedmodel(String name2, String msg2, String mail2) {
        this.name2 = name2;
        this.emil2 = msg2;
        this.msg2 = mail2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getEmil2() {
        return emil2;
    }

    public void setEmil2(String emil2) {
        this.emil2 = emil2;
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }
}
