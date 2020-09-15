package com.example.final_adminside;

public class projectmodel {

    String projectname;

    public projectmodel(){

    }


    public projectmodel(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
}
