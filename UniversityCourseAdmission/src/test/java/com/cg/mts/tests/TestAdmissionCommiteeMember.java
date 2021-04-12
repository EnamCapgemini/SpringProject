package tests;

import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class OnlineSalonServiceApplicationTests {
	@Autowired
	AppointmentServiceImpl appointmentService;
	
	@MockBean
	IAppointmentRepository appointmentRepository;
	@Test
	void contextLoads() {
	}
	
	
	
	
	

}