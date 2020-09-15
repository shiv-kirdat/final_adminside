package com.example.final_adminside;

public class event {

    String e_id;
    String e_name;
    String e_desc;
    String e_date;
    String e_addr;

    public  event(){

    }

    public event(String e_id, String e_name, String e_desc, String e_date, String e_addr) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_desc = e_desc;
        this.e_date = e_date;
        this.e_addr= e_addr;
    }

    public String getE_id() {
        return e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public String getE_desc() {
        return e_desc;
    }

    public String getE_date() {
        return e_date;
    }

    public String getE_addr() { return e_addr; }
}
