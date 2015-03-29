package org.crm.webservices.impl;

import org.crm.entities.Employee;
import org.crm.services.api.EmployeeService;
import org.crm.webservices.api.EmployeeWebService;
import org.crm.webservices.dto.EmployeeInfoDto;
import org.crm.webservices.mapping.ExtendedDozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.ArrayList;
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

    @Autowired
    private ExtendedDozerBeanMapper orderDataMapper;

    @GET
    @Path("Employees")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<EmployeeInfoDto> findAllEmployeesSortedByName() {
        List<Employee> employees = employeeService.findAllEmployeesSortedByName();
        List<EmployeeInfoDto> employeeInfoDtos = orderDataMapper.map(employees, EmployeeInfoDto.class);
        return employeeInfoDtos;
    }

    @GET
    @Path("ById/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public EmployeeInfoDto findEmployeeById(@PathParam("id") int id) {
        Employee employee = employeeService.findEmployeeById(id);
        EmployeeInfoDto employeeInfoDto = orderDataMapper.map(employee, EmployeeInfoDto.class);
        return employeeInfoDto;
    }

    @GET
    @Path("FirstName/{firstName}/SecondName/{secondName}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<EmployeeInfoDto> findEmployeesByFullName(
            @PathParam("firstName") @DefaultValue("") String firstName,
            @PathParam("secondName") @DefaultValue("") String secondName) {
        List<Employee> employees = new ArrayList<Employee>();
        if (firstName == null || firstName.isEmpty()) {
            employees = employeeService.findEmployeesBySecondNameAndSortedByFirstName(secondName);
        } else if (secondName == null || secondName.isEmpty()) {
            employees = employeeService.findEmployeesByFirstNameAndSortedBySecondName(firstName);
        } else {
            employees = employeeService.findEmployeesByFullName(firstName, secondName);
        }
        List<EmployeeInfoDto> employeeInfoDtos = orderDataMapper.map(employees, EmployeeInfoDto.class);
        return employeeInfoDtos;
    }

    @GET
    @Path("StartDate/{startDate}/EndDate/{endDate}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<EmployeeInfoDto> findEmployeesBetweenDurationAndSortedByName(
            @PathParam("startDate") @DefaultValue("0") long start,
            @PathParam("endDate") long end) {
        Date startDate = new Date(start);
        Date endDate = new Date(end);
        List<Employee> employees = employeeService.findEmployeesBetweenDurationAndSortedByName(startDate, endDate);
        List<EmployeeInfoDto> employeeInfoDtos = orderDataMapper.map(employees, EmployeeInfoDto.class);
        return employeeInfoDtos;
    }

    @POST
    @Path("_create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public EmployeeInfoDto createEmployee(Employee employee) {
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
