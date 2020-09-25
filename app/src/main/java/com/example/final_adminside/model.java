package com.example.final_adminside;

public class model {
    String e_name,e_desc,e_date,e_id,e_add;

    model(){

    }


    public model(String e_name,String e_desc,String e_date,String e_id,String e_add) {
        this.e_name = e_name;
        this.e_desc=e_desc;
        this.e_date=e_date;
        this.e_id=e_id;
        this.e_add=e_add;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }
    public String getE_desc() {
        return e_desc;
    }

    public void setE_desc(String e_desc) {
        this.e_desc = e_desc;
    }
    public String getE_date() {
        return e_date;
    }

    public void setE_date(String e_date) {
        this.e_date = e_date;
    }
    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_add() {
        return e_add;
    }

    public void setE_add(String e_add) {
        this.e_add = e_add;
    }


}
