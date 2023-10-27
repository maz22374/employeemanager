package at.spengergasse.employeemanager.repository;

import at.spengergasse.employeemanager.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository underTest;

    @Test
    void canDeleteEmployeeById() {
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
        underTest.save(employee); // Assuming there's a save method
        underTest.deleteEmployeeById(1L); // Assuming there's a deleteEmployeeById method
        Optional<Employee> deletedEmployee = underTest.findEmployeeById(1L); // Assuming there's a findEmployeeById method

        // then
        assertFalse(deletedEmployee.isPresent(), "Employee should be deleted");
    }

    @Test
    void canFindEmployeeById() {
        // given
        Employee employee = new Employee(
                2L,
                "Max Mustermann",
                "max@example.com",
                "SQL Developer",
                "0987654321",
                "https://example.com/max.jpg",
                UUID.randomUUID().toString()
        );
        underTest.save(employee); // Assuming there's a save method

        // when
        Optional<Employee> foundEmployee = underTest.findEmployeeById(2L); // Assuming there's a findEmployeeById method

        // then
        assertTrue(foundEmployee.isPresent(), "Employee should be found");
        assertEquals(employee, foundEmployee.get(), "Found employee should match the expected employee");
    }
}
