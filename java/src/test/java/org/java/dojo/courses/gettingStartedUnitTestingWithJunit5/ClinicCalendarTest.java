package org.java.dojo.courses.gettingStartedUnitTestingWithJunit5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClinicCalendarTest {

    @Test
    public void allowEntryOfAnAppointment() {
        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("Jim", "Weaver", "avery", "09/01/2018 2:00 pm");
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
    }
}
