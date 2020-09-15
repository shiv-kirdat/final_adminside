package com.example.final_adminside;

public class projectDetails {
    public String projectid, projectname, projectdescription,projectdate,projectplace;

    public projectDetails(){


    }

    public projectDetails(String projectid, String projectname, String projectdescription, String projectdate, String projectplace) {
        this.projectid = projectid;
        this.projectname = projectname;
        this.projectdescription = projectdescription;
        this.projectdate = projectdate;
        this.projectplace = projectplace;
    }

    public String getProjectid(){
        return projectid;
    }
    public String getProjectname() {
        return projectname;
    }


    public String getProjectdescription() {
        return projectdescription;
    }


    public String getProjectdate() {
        return projectdate;
    }


    public String getProjectplace() {
        return projectplace;
    }

}
