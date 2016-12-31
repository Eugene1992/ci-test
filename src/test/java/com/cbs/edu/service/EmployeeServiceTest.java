package com.cbs.edu.service;

import com.cbs.edu.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceTest {

    private List<Employee> employees;
    private List<Employee> emptyEmployees;
    private Employee testEmployee;

    @Before
    public void setUp() {
        testEmployee = new Employee("Ivan", 22, 10000);
        employees = new ArrayList<>();
        emptyEmployees = new ArrayList<>();
        employees.add(testEmployee);
        employees.add(testEmployee);
        employees.add(testEmployee);
    }

    @Test
    public void getAverageSalary() throws Exception {
        final int EXPECTED = testEmployee.getSalary();
        final int ACTUAL = EmployeeService.getAverageSalary(employees);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAverageSalaryEmptyList() throws Exception {
        final int ACTUAL = EmployeeService.getAverageSalary(emptyEmployees);
    }

}