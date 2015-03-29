package org.crm.webservices.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.inject.Inject;
import org.crm.entities.Employee;
import org.crm.services.api.EmployeeService;
import org.crm.webservices.api.EmployeeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.List;

/**
 * Created by Dachuan Zhao on 2015/3/14.
 * Employee component.
 */
@Component
@Path("_employee_resources")
public class EmployeeResource implements EmployeeWebService {

    @Autowired
    private EmployeeService employeeService;

    @GET
    @Path("Employees")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<Employee> findAllEmployeesSortedByName() {
        return employeeService.findAllEmployeesSortedByName();
    }

    @GET
    @Path("ById/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Employee findEmployeeById(@PathParam("id") int id)
    {
        return employeeService.findEmployeeById(id);
    }

    @GET
    @Path("FirstName/{firstName}/SecondName/{secondName}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<Employee> findEmployeesByFullName(
            @PathParam("firstName") @DefaultValue("") String firstName,
            @PathParam("secondName") @DefaultValue("") String secondName) {
        if (firstName == null || firstName.isEmpty()) {
            return employeeService.findEmployeesBySecondNameAndSortedByFirstName(secondName);
        } else if (secondName == null || secondName.isEmpty()) {
            return employeeService.findEmployeesByFirstNameAndSortedBySecondName(firstName);
        }
        return employeeService.findEmployeesByFullName(firstName, secondName);
    }

    @GET
    @Path("StartDate/{startDate}/EndDate/{endDate}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<Employee> findEmployeesBetweenDurationAndSortedByName(
            @PathParam("startDate") @DefaultValue("0") long start,
            @PathParam("endDate") long end) {
        Date startDate = new Date(start);
        Date endDate = new Date(end);
        return employeeService.findEmployeesBetweenDurationAndSortedByName(startDate, endDate);
    }

    @POST
    @Path("_create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Employee createEmployee(Employee employee) {
        return null;
    }

    @POST
    @Path("_update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @DELETE
    @Path("_delete")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public boolean deleteEmployee(Employee employee) {
        return false;
    }
}
