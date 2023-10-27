package at.spengergasse.employeemanager.service;

import at.spengergasse.employeemanager.model.Employee;
import at.spengergasse.employeemanager.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    EmployeeRepository employeeRepository;
    EmployeeService underTest;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class); // Mock the repository
        underTest = new EmployeeService(employeeRepository);
    }

    @Test
    void addEmployee() {
        // given
        Employee employee = new Employee(
                1L,
                "John Doe",
                "john@example.com",
                "Software Engineer",
                "1234567890",
                "https://example.com/john.jpg",
                UUID.randomUUID().toString()
        );

        // when
        underTest.addEmployee(employee);

        // then
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void findAllEmployees() {
        // given
        Employee employee1 = new Employee(
                3L,
                "John Doe",
                "john@example.com",
                "Software Engineer",
                "1234567890",
                "https://example.com/john.jpg",
                UUID.randomUUID().toString()
        );
        Employee employee2 = new Employee(
                4L,
                "Max Mustermann",
                "max@example.com",
                "SQL Developer",
                "0987654321",
                "https://example.com/max.jpg",
                UUID.randomUUID().toString()
        );

        // Mock the behavior of the repository to return a list of employees when findAllEmployees is called
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        // when
        List<Employee> employees = underTest.findAllEmployees();

        // then
        assertEquals(2, employees.size(), "Expected two employees");
        assertTrue(employees.contains(employee1), "Employee 1 should be in the list");
        assertTrue(employees.contains(employee2), "Employee 2 should be in the list");
    }

    @Test
    void updateEmployee() {
        // given

        // when

        // then
    }

    @Test
    void findEmployeeById() {
        // given

        // when

        // then
    }

    @Test
    void deleteEmployee() {
        // given

        // when

        // then
    }
}