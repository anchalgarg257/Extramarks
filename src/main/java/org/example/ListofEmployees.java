package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class ListofEmployees {

    public static void main(String[] args) {

        final String CSV_LOCATION = "Employee.csv ";

        try {

            // Creating writer class to generate
            // csv file
            FileWriter writer = new FileWriter("D:/Path");

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

                // Create Mapping Strategy to arrange the
                // column name in order
                ColumnPositionMappingStrategy mappingStrategy=
                        new ColumnPositionMappingStrategy();
                mappingStrategy.setType(Employee.class);

                // Arrange column name as provided in below array.
                String[] columns = new String[]
                        { "Name", "Age", "Company", "Salary", "Department"};
                mappingStrategy.setColumnMapping(columns);

                // Createing StatefulBeanToCsv object
                StatefulBeanToCsvBuilder<Employee> builder=
                        new StatefulBeanToCsvBuilder(writer);
                StatefulBeanToCsv beanWriter =
                        builder.withMappingStrategy(mappingStrategy).build();

                // Write list to StatefulBeanToCsv object
                beanWriter.write(EmployeeList);

                // closing the writer object
                writer.close();
            }
        }
//        System.out.println("The details of the employees are as follows:");
//        System.out.println("Employee ID" + "\t" + "Employee name" + "\t" + "Employee Salary" + "" +
//                "\t" + "Company Location" + "\t" + "Department");
//        for (EmployeeBean employeeBean  : list) {
//            System.out.println(employeeBean.getId() + "\t" + employeeBean.getName() + "\t" + employeeBean.getSalary() + "\t" +
//                    employeeBean.getDepartment() + "\t" + employeeBean.getLocation());
//        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}