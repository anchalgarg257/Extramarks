package org.example;

public class CompanyBean {

    private String department;
    private String location;

    public CompanyBean(String department, String location) {

        this.department = department;
        this.location = location;
    }

    public CompanyBean() {

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
