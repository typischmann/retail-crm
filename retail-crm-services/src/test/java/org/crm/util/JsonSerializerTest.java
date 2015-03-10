package org.crm.util;

import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class JsonSerializerTest {

    private Employee employee1;
    private Employee employee2;
    private List<Employee> employees;
    @Before
    public void setUp() throws Exception {
        employees = new ArrayList<Employee>();
        employee1 = new Employee();
        employee1.setFirstName("Obama");
        employee1.setSecondName("Whocare");
        Department department = new Department();
        department.setId(1);
        department.setName("White House");
        department.setName_en("WH");
        employee1.setDepartment(department);
        employee1.setStartDate(new Date(System.currentTimeMillis()));
        employee1.setNote("This guy forces people to buy health care.");
        employee1.setId(100);
        employees.add(employee1);

        employee2 = new Employee();
        employee2.setFirstName("Clinton");
        employee2.setSecondName("Bill");
        employee2.setDepartment(department);
        employee2.setStartDate(new Date(System.currentTimeMillis()));
        employee2.setNote("This guy starts a war.");
        employee2.setId(101);
        employees.add(employee2);
    }

    @Test
    public void testToJson() throws Exception {
        String result = JsonSerializer.toJson(employee1);
        System.out.println(result);
        assertTrue(result.contains("Obama"));
        assertTrue(result.contains("Whocare"));

        System.out.println(JsonSerializer.toJson(employees));
    }

    @Test
    public void testFromJson() throws Exception {
        String result = JsonSerializer.toJson(employee1);
        Employee emp = JsonSerializer.fromJson(result, Employee.class);
        assertTrue(emp.getFirstName().equals("Obama"));
        assertTrue(emp.getDepartment().getName().equals("White House"));
    }
}