package com.example.final_adminside;

public class projectmodel {

    String projectname,projectdesc,projectplace,projectdate,projectid;

    public projectmodel(){

    }


    public projectmodel(String projectname,String projectdesc,String projectplace,String projectdate,String projectid )
    {
        this.projectname = projectname;
        this.projectdesc=projectdesc;
        this.projectdate=projectdate;
        this.projectplace=projectplace;
        this.projectid=projectid;
    }

    public String getProjectdesc() {
        return projectdesc;
    }

    public void setProjectdesc(String projectdesc) {
        this.projectdesc = projectdesc;
    }

    public String getProjectplace() {
        return projectplace;
    }

    public void setProjectplace(String projectplace) {
        this.projectplace = projectplace;
    }

    public String getProjectdate() {
        return projectdate;
    }

    public void setProjectdate(String projectdate) {
        this.projectdate = projectdate;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
}
