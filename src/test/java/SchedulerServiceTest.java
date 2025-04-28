import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tecno_comfenalco.easywashproject.models.Appointment;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.services.SchedulerService;

class SchedulerServiceTest {

    @Test
    void testAssignEmployeeWhenEmployeeIsAvailable() {
        // Arrange
        Employee employee = mock(Employee.class);
        when(employee.isEmployeeAvailable(any(), any(), any())).thenReturn(true);

        List<Employee> employees = List.of(employee);
        Appointment appointment = mock(Appointment.class);
        when(appointment.getDate()).thenReturn(LocalDate.now());
        when(appointment.getStartTime()).thenReturn(Duration.ofHours(9));
        when(appointment.getDurationAppointment()).thenReturn(Duration.ofHours(1));

        // Act
        Employee assignedEmployee = SchedulerService.assignEmployee(employees, LocalDate.now(), Duration.ofHours(9),
                appointment);

        // Assert
        assertNotNull(assignedEmployee);
        assertEquals(employee, assignedEmployee);
    }

    @Test
    void testAssignEmployeeWhenNoEmployeeIsAvailable() {
        // Arrange
        Employee employee = mock(Employee.class);
        when(employee.isEmployeeAvailable(any(), any(), any())).thenReturn(false);

        List<Employee> employees = List.of(employee);
        Appointment appointment = mock(Appointment.class);

        // Act
        Employee assignedEmployee = SchedulerService.assignEmployee(employees, LocalDate.now(), Duration.ofHours(9),
                appointment);

        // Assert
        assertNull(assignedEmployee);
    }
}
