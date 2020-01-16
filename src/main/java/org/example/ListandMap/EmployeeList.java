package org.example.ListandMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeList {
    public static void main(String[] args) {

        List<EmployeeBean> list = new ArrayList<>();

        EmployeeBean employeeBean1 = new EmployeeBean();

        employeeBean1.setName("Anchal");
        employeeBean1.setId(1);
        employeeBean1.setAddress("Delhi");
        employeeBean1.setSalary(1000);
        list.add(employeeBean1);

        EmployeeBean employeeBean2 = new EmployeeBean();
        employeeBean2.setName("Shivani");
        employeeBean2.setId(2);
        employeeBean2.setAddress("Malasia");
        employeeBean2.setSalary(2000);
        list.add(employeeBean2);

//        Iterator<EmployeeBean> abciterator =  list.iterator();
//
//        System.out.println("Name   " + "Id     " + "Address     " + "Salary     ");
//
//        while (abciterator.hasNext()) {
//           EmployeeBean employeeBean = abciterator.next();
//
//            System.out.println(employeeBean.getName() + "\t" + employeeBean.getId()+ "\t" +
//                    employeeBean.getAddress() + "\t" + employeeBean.getSalary());

            for(EmployeeBean employeeBean : list) {
                System.out.println(employeeBean.getName()+"\t"+employeeBean.getSalary()+"\t"+
                        employeeBean.getAddress()+"\t"+employeeBean.getId());

        }
    }
}
