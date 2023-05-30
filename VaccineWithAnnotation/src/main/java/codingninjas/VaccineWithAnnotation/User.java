package codingninjas.VaccineWithAnnotation;

import org.springframework.stereotype.Component;

@Component
public interface User {

    void setUserDetails(String name, int age, TimeAndLocation timeAndLocation);

    void setAppointment();

    boolean IsVaccinated();

    void setVaccine(String vaccine);

}
