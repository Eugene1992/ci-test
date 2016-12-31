package com.cbs.edu.service;

import com.cbs.edu.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
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

    @Test
    public void getTotalSalary() throws Exception {
        final int EXPECTED = testEmployee.getSalary() * employees.size();
        final int ACTUAL = EmployeeService.getTotalSalary(employees);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTotalSalaryEmptyList() throws Exception {
        final int ACTUAL = EmployeeService.getTotalSalary(emptyEmployees);
    }

    @Test
    public void testConstructorIsPrivate()
            throws NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Constructor<EmployeeService> constructor = EmployeeService.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}