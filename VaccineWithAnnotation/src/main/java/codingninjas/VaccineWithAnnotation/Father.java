package codingninjas.VaccineWithAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Father")
public class Father implements User{

    private String name;
    private int age;
    private boolean isVaccinated = false;

    @Autowired
    private TimeAndLocation timeAndLocation;
    private Vaccine vaccine;

    @Autowired
    @Qualifier("Covaxin")
    private Vaccine covaxin;

    @Autowired
    @Qualifier("Covishield")
    private Vaccine covishield;

    @Autowired
    @Qualifier("Moderna")
    private Vaccine moderna;

    @Override
    public void setUserDetails(String name, int age, TimeAndLocation timeAndLocation) {
        this.name = name;
        this.age = age;
        this.timeAndLocation = timeAndLocation;
    }

    @Override
    public void setAppointment() {
        this.isVaccinated = true;
        String vaccineType = vaccine.getType();
        System.out.println("Hello " + name + " your appointment has been fixed for " + vaccineType
                + " on " + timeAndLocation.getDetails());
    }

    @Override
    public boolean IsVaccinated() {
        return isVaccinated;
    }

    @Override
    public void setVaccine(String vaccine) {
        if(vaccine.equals("Covaxin"))
            this.vaccine = covaxin;
        else if(vaccine.equals("covishield"))
            this.vaccine = covishield;
        else this.vaccine = moderna;
    }

}
