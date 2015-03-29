package org.crm.util;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;




import org.crm.dao.model.EmployeeDao;
import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class JsonSerializerResourceTest {
	
	@Autowired
	private EmployeeDao employeeDao;
	

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
        department.setNameEn("WH");
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
        
        department.setEmployees(employees);
        
    }

    @Test
    public void testToJson() throws Exception {
        String result = JacksonJsonSerializer.toJson(employee1);
        System.out.println(result);
        assertTrue(result.contains("Obama"));
        assertTrue(result.contains("Whocare"));

        System.out.println("Emloyee List: "+JacksonJsonSerializer.toJson(employees));
    }

    @Test
    public void testFromJson() throws Exception {
        String result = JacksonJsonSerializer.toJson(employee1);
        System.out.println("Parsed Employee: "+result);
        Employee emp = JacksonJsonSerializer.fromJson(result, Employee.class);
        assertTrue(emp.getFirstName().equals("Obama"));
        assertTrue(emp.getDepartment().getName().equals("White House"));
    }
    
    @Test
    public void testFromJsonDepartment() throws Exception {
        String result = JacksonJsonSerializer.toJson(employee1.getDepartment());
        System.out.println("Department: "+result);
        Department department = JacksonJsonSerializer.fromJson(result, Department.class);
        Employee emp = department.getEmployees().get(0);
        assertTrue(emp.getFirstName().equals("Obama"));
        assertTrue(emp.getDepartment().getName().equals("White House"));
    }
	
	@Test
	public void testPrintToJsonForOneEmployeeWithJackson(){
		employees = employeeDao.findEmployeesByFullName("晓霞", "曾");
        assertTrue(employees.size() == 1);
        assertTrue(employees.get(0).getFirstName().equals("晓霞"));
        Employee employee=employees.get(0);
        employee.getDepartment();
        String jsonString = JacksonJsonSerializer.toJson(employee);
        Assert.assertNotNull(jsonString);
        System.out.println(jsonString);
	}
}
