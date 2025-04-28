import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.services.AppointmentBookingService;

class AppointmentBookingServiceTest {

    @Test
    void testCreateAppointmentWithAvailableEmployee() {
        // Arrange
        Employee employee = mock(Employee.class);
        when(employee.isEmployeeAvailable(any(), any(), any())).thenReturn(true);
        when(employee.getFullname()).thenReturn("John Doe");

        List<Employee> employees = List.of(employee);
        AppointmentBookingService service = new AppointmentBookingService(employees);

        Client client = mock(Client.class);
        List<Service> services = List.of(mock(Service.class));

        // Act
        service.createAppointment(LocalDate.now(), Duration.ofHours(9), services, client);

        // Assert
        verify(employee, times(1)).getAppointments();
    }

    @Test
    void testCreateAppointmentWithNoAvailableEmployee() {
        // Arrange
        Employee employee = mock(Employee.class);
        when(employee.isEmployeeAvailable(any(), any(), any())).thenReturn(false);

        List<Employee> employees = List.of(employee);
        AppointmentBookingService service = new AppointmentBookingService(employees);

        Client client = mock(Client.class);
        List<Service> services = List.of(mock(Service.class));

        // Act
        service.createAppointment(LocalDate.now(), Duration.ofHours(9), services, client);

        // Assert
        verify(employee, never()).getAppointments();
    }
}