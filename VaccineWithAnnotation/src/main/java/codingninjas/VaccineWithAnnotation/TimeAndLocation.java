package codingninjas.VaccineWithAnnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TimeAndLocation {

    private String time;
    private String date;
    private String location;

    void setDetails(String time, String date, String location){
        this.date = date;
        this.location = location;
        this.time = time;
    }

    public String getDetails() {
        return this.time + " at " + this.location + " on " + this.date;
    }
}
