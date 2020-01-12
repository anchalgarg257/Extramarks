package org.example;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;


public class CSVtoClassEmployee {
    private static final String SAMPLE_CSV_FILE_PATH = "D:/Path/Employee.csv";

    public static void main(String[] args) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));)
        {
            ColumnPositionMappingStrategy mappingStrategy=
                    new ColumnPositionMappingStrategy();
            mappingStrategy.setType(EmployeeBean.class);

            // Arrange column name as provided in below array.
            String[] columns = new String[]
                    {"Id", "Name", "Salary", "Location", "Department"};
            mappingStrategy.setColumnMapping(columns);


            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(EmployeeBean.class).withMappingStrategy(mappingStrategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<EmployeeBean> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                EmployeeBean employeeBean = csvUserIterator.next();
                System.out.println("ID : " + employeeBean.getId());
                System.out.println("Name : " + employeeBean.getName());
                System.out.println("Salary : " + employeeBean.getSalary());
                System.out.println("Location : " + employeeBean.getLocation());
                System.out.println("Department : " + employeeBean.getDepartment());
            }
        }
    }
}
