package org.example;

public class EmployeeBean extends CompanyBean {

    private int id;
    private String name;
    private String salary;

    public EmployeeBean(String department, String location, int id, String name, String salary) {
        super(department, location);
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public EmployeeBean() {
        super();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
