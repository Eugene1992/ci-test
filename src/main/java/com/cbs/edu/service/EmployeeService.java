package com.cbs.edu.service;

import com.cbs.edu.model.Employee;

import java.util.List;

/**
 * Utility class for {@link Employee} entity.
 * @see Employee
 */
public final class EmployeeService {

    private EmployeeService() {
    }

    /**
     * Calculate average employee salary.
     * @param employees input list of employees.
     * @return average salary for input employees
     * @throws IllegalArgumentException when input list is empty
     */
    public static int getAverageSalary(List<Employee> employees) throws IllegalArgumentException {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Empty employees list");
        }
        int total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total / employees.size();
    }

    /**
     * Calculate total employee salary.
     * @param employees input list of employees.
     * @return total salary for input employees
     * @throws IllegalArgumentException when input list is empty
     */
    public static int getTotalSalary(List<Employee> employees) throws IllegalArgumentException {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Empty employees list");
        }
        int total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }
}
