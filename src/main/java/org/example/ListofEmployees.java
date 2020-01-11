package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListofEmployees {

    public static void main (String [] args) {

        System.out.println("Enter the details of 2 Employees");
        Scanner scanner = new Scanner(System.in);
        List<EmployeeBean> list = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {

            EmployeeBean e1 = new EmployeeBean();

            System.out.println("Enter the id of employee " + i);
            e1.setId(Integer.parseInt(scanner.next()));

            System.out.println("Enter the name of the employee " + i);
            e1.setName(scanner.next());

            System.out.println("Enter the salary of the employee" + i);
            e1.setSalary(scanner.next());

            System.out.println("Enter the location of the company" + i);
            e1.setLocation(scanner.next());

            System.out.println("Enter the department of the company" + i);
            e1.setDepartment(scanner.next());

            list.add(e1);
        }System.out.println("The details of the employees are as follows:");
        System.out.println("Employee ID" + "\t" + "Employee name" + "\t" + "Employee Salary" + "" +
                "\t" + "Company Location" + "\t" + "Department");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t" + list.get(i).getSalary() +
                    "\t" + list.get(i).getLocation() + "\t" + list.get(i).getDepartment());
        }

    }
}
