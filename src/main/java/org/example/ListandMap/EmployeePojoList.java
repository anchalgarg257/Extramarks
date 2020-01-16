package org.example.ListandMap;

import java.util.ArrayList;
import java.util.List;

public class EmployeePojoList {

    public static void main (String[] args) {

        List<EmployeePojo> list = new ArrayList<>();

        EmployeePojo employeePojo1 = new EmployeePojo("Anchal", 2, "Delhi", 1000);
        EmployeePojo employeePojo2 = new EmployeePojo("Shivani", 5, "Malasia", 2000);

        list.add(employeePojo1);
        list.add(employeePojo2);

        for(EmployeePojo employeePojo : list) {
            System.out.println(employeePojo.getName());
            System.out.println(employeePojo.getId());
            System.out.println(employeePojo.getAddress());
            System.out.println(employeePojo.getSalary());
        }

    }
}
