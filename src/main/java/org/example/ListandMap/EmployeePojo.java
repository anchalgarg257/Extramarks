package org.example.ListandMap;

public class EmployeePojo {
    private String name;
    private int id;
    private String address;
    private int salary;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }

    public EmployeePojo(String name, int id, String address, int salary) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.salary = salary;

    }
}
